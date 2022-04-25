package com.ncu.bbs.services.impl;

import com.ncu.bbs.bean.Main;
import com.ncu.bbs.bean.MainExample;
import com.ncu.bbs.dao.MainMapper;
import com.ncu.bbs.services.mainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class mainServiceImpl implements mainService {
    @Autowired
    MainMapper mainMapper;
    public Main getMainById(int mainid) {
        MainExample mainExample=new MainExample();
        mainExample.or();
        mainExample.or().andMMainidEqualTo(mainid);
        List<Main> list= mainMapper.selectByExample(mainExample);
        if (list.size()==0)
            return null;
        else
           return list.get(0);

    }

    public void deleteMainById(int mainid) {
        MainExample mainExample=new MainExample();
        mainExample.or();
        mainExample.or().andMMainidEqualTo(mainid);
        mainMapper.deleteByExample(mainExample);
    }
    @Override
    public void modifyMainContentById(String content, int mainid) {
        MainExample mainExample=new MainExample();
        mainExample.or();
        mainExample.or().andMMainidEqualTo(mainid);
        Main main=new Main();
        main.setmContent(content);
        main.setmMainid(mainid);
        mainMapper.updateByExampleSelective(main,mainExample);
    }
/**
 * wale
 */

    /**
     * 根据版块id查找某一个版块的所有帖子
     * @param sectionId
     * @return
     */
    public List<Main> getMainBySectionId(Integer sectionId) {
        List<Main> mainlist=new ArrayList<Main>();
        MainExample mainExample=new MainExample();
        MainExample.Criteria criteria=mainExample.createCriteria();
        criteria.andMSectionidEqualTo(sectionId);
        mainExample.setOrderByClause("m_maindate desc");//按照发布时间排序
        mainlist=mainMapper.selectByExampleWithMainer(mainExample);//带有发布者信息的查询
        return mainlist;
    }

    /**
     * 根据版块id和符合条件的数量num查找某个版块的num个帖子
     * @param sectionId
     * @param num
     * @return
     */
    public List<Main> getMainBySectionIdAndNum(Integer sectionId, int num) {
        List<Main> mainlist=new ArrayList<Main>();
        MainExample mainExample=new MainExample();
        MainExample.Criteria criteria=mainExample.createCriteria();
        criteria.andMSectionidEqualTo(sectionId);
        criteria.andMIsperfectEqualTo(1);//查找某一个版块的所有精华帖
        mainlist=mainMapper.selectByExample(mainExample);
        List<Main> finals=new ArrayList<Main>();
        for(int i=0;i<mainlist.size();i++){
            if(i<num){
                finals.add(mainlist.get(i));
            }
        }
        return finals;
    }

    /**
     * 根据版块id查找该板块的所有置顶帖
     * @param sectionId
     * @return
     */
    public List<Main> getTopMain(Integer sectionId) {
        List<Main> mainlist=new ArrayList<Main>();
        MainExample mainExample=new MainExample();
        MainExample.Criteria criteria=mainExample.createCriteria();
        criteria.andMSectionidEqualTo(sectionId);
        criteria.andMIsontopEqualTo(1);//查找置顶帖
        mainlist=mainMapper.selectByExampleWithMainer(mainExample);//带有发布者信息的查询
        return mainlist;
    }

    /**
     * 根据版块id查找所有的不是置顶帖的帖子
     * @param sectionId
     * @return
     */
    public List<Main> getNotTopMainBySectionId(Integer sectionId) {
        List<Main> mainlist=new ArrayList<Main>();
        MainExample mainExample=new MainExample();
        MainExample.Criteria criteria=mainExample.createCriteria();
        criteria.andMSectionidEqualTo(sectionId);
        criteria.andMIsontopEqualTo(0);//查找非置顶帖
        mainExample.setOrderByClause("m_maindate desc");//按照时间进行排序
        mainlist=mainMapper.selectByExampleWithMainer(mainExample);//带有发布者信息的查询
        return mainlist;
    }

    /**
     * 根据版块id来查找所有不是精华帖的帖子
     * @param sectionId
     * @return
     */
    public List<Main> getNotPerfectMainBySectionId(Integer sectionId) {
        List<Main> mainlist=new ArrayList<Main>();
        MainExample mainExample=new MainExample();
        MainExample.Criteria criteria=mainExample.createCriteria();
        criteria.andMSectionidEqualTo(sectionId);
        criteria.andMIsperfectEqualTo(0);//查找非精华帖
        mainExample.setOrderByClause("m_maindate desc");//按照时间进行排序
        mainlist=mainMapper.selectByExampleWithMainer(mainExample);//带有发布者信息的查询
        return mainlist;
    }

    /**
     * 根据主贴id批量增加精华帖
     * @param del_ids
     */
    public void addPerfectBatch(List<Integer> del_ids) {
        for (int mainId:del_ids) {
            MainExample mainExample=new MainExample();
            MainExample.Criteria criteria =mainExample.createCriteria();
            criteria.andMMainidEqualTo(mainId);
            Main main=new Main();
            main.setmIsperfect(1);
            mainMapper.updateByExampleSelective(main,mainExample);
        }
    }

    /**
     * 根据主贴id来加精
     * @param id
     */
    public void addPerfect(Integer id) {
        MainExample mainExample=new MainExample();
        MainExample.Criteria criteria =mainExample.createCriteria();
        criteria.andMMainidEqualTo(id);
        Main main=new Main();
        main.setmIsperfect(1);
        mainMapper.updateByExampleSelective(main,mainExample);
    }

    /**
     * 根据主贴id查找版块id
     * @param mainId
     * @return
     */
    public int getSectionIdByMainId(Integer mainId) {
        Main main=mainMapper.selectByPrimaryKey(mainId);
        return main.getmSectionid();
    }

    /**
     * 根据主贴id来取消置顶帖子
     * @param mainId
     */
    public void cancelTopByMainId(Integer mainId) {
        Main main=new Main();
        main.setmMainid(mainId);
        main.setmIsontop(0);
        mainMapper.updateByPrimaryKeySelective(main);
    }

    /**
     * 根据主帖编号取消加精多个帖子
     * @param del_ids
     */
    public void cancelPerfectBatch(List<Integer> del_ids) {
        for (Integer del_id : del_ids) {
            cancelPerfect(del_id);
        }
    }
    /**
     * 根据主帖编号取消加精单个帖子
     * @param
     */
    public void cancelPerfect(Integer id) {
        Main main=new Main();
        main.setmMainid(id);
        main.setmIsperfect(0);//非精华帖
        mainMapper.updateByPrimaryKeySelective(main);
    }

    /**
     * 根据主贴id来查找帖子包含发布该帖子的信息
     * @param mainId
     * @return
     */
    public Main getMainByMainId(Integer mainId) {
        return mainMapper.selectByPrimaryKeyWithMainer(mainId);
    }

    /**
     * 根据版块id查找该版块的所有需求帖
     * @param sectionId
     */
    @Override
    public List<Main> getNeedPostBySectionId(Integer sectionId) {
        MainExample mainExample=new MainExample();
        MainExample.Criteria criteria=mainExample.createCriteria();
        criteria.andMPointGreaterThan(0);
        criteria.andMSectionidEqualTo(sectionId);
        //按照回复数来进行排序
        mainExample.setOrderByClause("m_point desc");//按照时间进行排序
        return mainMapper.selectByExampleWithMainer(mainExample);
    }

    /**
     * 根据版块id查找所有的热门帖
     * @param sectionId
     * @return
     */
    @Override
    public List<Main> getHotPostBySectionId(Integer sectionId) {
        MainExample mainExample=new MainExample();
        MainExample.Criteria criteria=mainExample.createCriteria();
        criteria.andMSectionidEqualTo(sectionId);
        return mainMapper.selectByExampleWithFollowNums(mainExample);
    }

    /**
     * 根据版块id查找所有最新帖
     * @param sectionId
     * @param deadline
     * @return
     */
    @Override
    public List<Main> getLatestPostBySectionId(Integer sectionId, Date deadline) {
        MainExample mainExample=new MainExample();
        MainExample.Criteria criteria=mainExample.createCriteria();
        criteria.andMSectionidEqualTo(sectionId);
        criteria.andMMaindateGreaterThan(deadline);
        mainExample.setOrderByClause("m_maindate desc");
        return mainMapper.selectByExampleWithMainer(mainExample);
    }

    /**
     * 根据关键字查找相关的所有帖子
     * @param keyWord
     * @return
     */
    @Override
    public List<Main> searchMainsByKeyWord(String keyWord) {
        MainExample mainExample=new MainExample();
        MainExample.Criteria criteria=mainExample.createCriteria();
        criteria.andMTitleLike("%"+keyWord+"%");
        return mainMapper.selectByExampleWithMainer(mainExample);
    }

    /**
     * 根据发帖者的id查找该发帖者发布的所有主贴
     * @param userid
     * @return
     */
    @Override
    public List<Main> getMainByMainerId(int userid) {
        MainExample mainExample=new MainExample();
        MainExample.Criteria criteria=mainExample.createCriteria();
        criteria.andMMaineridEqualTo(userid);
        return mainMapper.selectByExample(mainExample);
    }

    /**
     * 返回系统中所有的帖子
     * @return
     */
    @Override
    public List<Main> getAllPosts() {
        MainExample mainExample=new MainExample();
        MainExample.Criteria criteria=mainExample.createCriteria();
        criteria.andMMainidIsNotNull();
        return mainMapper.selectByExampleWithMainer(mainExample);
    }

    /**
     * 根据给定的主帖更新原来的主帖
     * @param main
     */
    @Override
    public void updateMainByMain(Main main) {
        mainMapper.updateByPrimaryKeySelective(main);
    }

    /**
     * 根据帖子id批量删除帖子
     * @param del_ids
     */
    @Override
    public void deleteMains(List<Integer> del_ids) {
        for (Integer del_id : del_ids) {
            deleteMain(del_id);
        }
    }

    /**
     * 根据帖子id删除单个帖子
     * @param id
     */
    @Override
    public void deleteMain(Integer id) {
        mainMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据版块id来查找该版块的所有精华帖
     * @param sectionId
     * @return
     */
    public List<Main> getPerfectBySectionId(Integer sectionId) {
        List<Main> perfectlist=new ArrayList<Main>();
        MainExample example=new MainExample();
        MainExample.Criteria criteria=example.createCriteria();
        criteria.andMIsperfectEqualTo(1);
        criteria.andMSectionidEqualTo(sectionId);
        perfectlist=mainMapper.selectByExampleWithMainer(example);
        return perfectlist;
    }

    /**
     * 根据main增加一个主贴记录
     * @param main
     */
    public void addMainPost(Main main) {
        mainMapper.insertSelective(main);
    }

    /**
     * 批量增加置顶帖
     * @param del_ids
     */
    public void addTopBatch(List<Integer> del_ids) {
        for (int mainId:del_ids) {
            MainExample mainExample=new MainExample();
            MainExample.Criteria criteria =mainExample.createCriteria();
            criteria.andMMainidEqualTo(mainId);
            Main main=new Main();
            main.setmIsontop(1);
            mainMapper.updateByExampleSelective(main,mainExample);
        }
    }

    /**
     *置顶单个帖子
     * @param id
     */
    public void addTop(Integer id) {
        MainExample mainExample=new MainExample();
        MainExample.Criteria criteria =mainExample.createCriteria();
        criteria.andMMainidEqualTo(id);
        Main main=new Main();
        main.setmIsontop(1);
        mainMapper.updateByExampleSelective(main,mainExample);
    }

}
