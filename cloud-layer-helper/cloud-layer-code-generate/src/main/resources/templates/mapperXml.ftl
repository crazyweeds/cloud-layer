<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="net.sirun.product.mapper.AppOperationLogMapper">

    <resultMap id="BaseResultMap" type="net.sirun.product.bean.dto.AppOperationLog">
        <id column="id" jdbcType="BIGINT" property="id"/>
        <result column="vin" jdbcType="VARCHAR" property="vin"/>
    </resultMap>

    <sql id="Base_Column_List">
        id,
        vin,
        optional_name,
        optional_path,
        username,
        user_id,
        ip_address,
        create_time,
        delete_flag,
        http_state,
        http_result
    </sql>


</mapper>
