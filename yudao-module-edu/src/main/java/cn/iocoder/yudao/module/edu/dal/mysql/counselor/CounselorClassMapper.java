package cn.iocoder.yudao.module.edu.dal.mysql.counselor;

import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.edu.dal.dataobject.counselor.CounselorClassDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;

/**
 * 辅导员带班 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface CounselorClassMapper extends BaseMapperX<CounselorClassDO> {

    default List<CounselorClassDO> selectListByCounselorId(Long counselorId) {
        return selectList(CounselorClassDO::getCounselorId, counselorId);
    }

    default List<CounselorClassDO> selectListByCounselorIds(Collection<Long> counselorIds) {
        return selectList(CounselorClassDO::getCounselorId, counselorIds);
    }

    default List<CounselorClassDO> selectListByClassName(String className) {
        return selectList(CounselorClassDO::getClassName, className);
    }

    default Long selectCountByCounselorId(Long counselorId) {
        return selectCount(CounselorClassDO::getCounselorId, counselorId);
    }

    default int deleteByCounselorId(Long counselorId) {
        return delete(CounselorClassDO::getCounselorId, counselorId);
    }

}
