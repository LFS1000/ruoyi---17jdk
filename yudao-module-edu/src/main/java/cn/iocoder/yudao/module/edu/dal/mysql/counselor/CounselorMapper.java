package cn.iocoder.yudao.module.edu.dal.mysql.counselor;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.edu.controller.admin.counselor.vo.CounselorPageReqVO;
import cn.iocoder.yudao.module.edu.dal.dataobject.counselor.CounselorDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 辅导员 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface CounselorMapper extends BaseMapperX<CounselorDO> {

    default CounselorDO selectByJobNo(String jobNo) {
        return selectOne(CounselorDO::getJobNo, jobNo);
    }

    default PageResult<CounselorDO> selectPage(CounselorPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CounselorDO>()
                .likeIfPresent(CounselorDO::getJobNo, reqVO.getJobNo())
                .likeIfPresent(CounselorDO::getName, reqVO.getName())
                .eqIfPresent(CounselorDO::getGender, reqVO.getGender())
                .likeIfPresent(CounselorDO::getMobile, reqVO.getMobile())
                .likeIfPresent(CounselorDO::getTitle, reqVO.getTitle())
                .eqIfPresent(CounselorDO::getDeptId, reqVO.getDeptId())
                .eqIfPresent(CounselorDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(CounselorDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(CounselorDO::getId));
    }

}
