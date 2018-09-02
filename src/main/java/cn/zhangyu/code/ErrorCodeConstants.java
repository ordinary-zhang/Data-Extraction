package cn.zhangyu.code;

/**
 * 错误码的常量定义
 */
public interface ErrorCodeConstants {
    /**
     * 后台请求成功:请求成功的默认返回
     */
    String REQUEST_SUCCESS = "00000";
    /**
     * 后台请求失败:请求失败的默认返回
     */
    String REQUEST_FAIL = "09999";
    /**
     * 单点登录失败:使用单点登录时，无法完成认证
     */
    String LOGIN_FAILED = "10000";
    /**
     * 非法的TICKET:CAS_SERVER获取TICKET出现错误
     */
    String ILLEGAL_TICKET = "10001";
    /**
     * 用户标识参数错误:AS_SERVER获取SERVICE参数错误
     */
    String ERROR_USER_MARK_PARAM = "10002";
    /**
     * 用户标识错误:用户表示为空或用户不存在
     */
    String ERROR_USER_MARK = "10003";
    /**
     * service url不能为空:单点登录未指定重定向的service url
     */
    String SERVICE_URL_NULL = "10004";
    /**
     * Token验证错误:登录验证的Token验证不通过
     */
    String TOKEN_VALIDATE_FAILED = "10005";
    /**
     * HTTP请求连接错误
     */
    String HTTP_URL_CONNECTION_ERROR = "10006";
    /**
     * 客户端认证失败:用户服务端对客户端访问设限时，客户端无法通过认证
     */
    String CLIENT_AUTHENTICATION_FAILED = "10100";
    /**
     * 客户端IP不正确:客户端IP不被允许访问服务
     */
    String CLIENT_IP_ERROR = "10101";
    /**
     * 客户端MAC不正确:客户端MAC不被允许访问服务
     */
    String CLIENT_MAC_ERROR = "10102";
    /**
     * 客户端登录类型异常:客户端异常方式登录
     */
    String CLIENT_LOGIN_TYPE_EXCEPTION = "10103";
    /**
     * 平台初始化异常
     */
    String PLATFORM_INIT_ERROR = "10200";
    /**
     * 平台初始化未完成:IndexCode未初始化
     */
    String PLATFORM_INIT_UNFINISH = "10201";
    /**
     * 数据目录内部错误:对数据目录进行增删改查出现的错误
     */
    String INIT_CATALOG_ERROR = "30000";
    /**
     * 数据目录新增错误:对数据目录进行新增出现的错误
     */
    String ADD_CATALOG_ERRPR = "30100";
    /**
     * 添加目录失败，名称重复:同一目录下，新增目录名称不可重复
     */
    String ADD_CATALOG_NAME_REPETION = "30101";
    /**
     * 该目录下不能创建目录	:目录下不能创建目录的提示
     */
    String ADD_IN_INIT_CATALOG_ERROR = "30102";
    /**
     * 目录名称为空或太长:新增目录时，目录名称为空或太长
     */
    String ADD_CATALOG_NAME_ERROR = "30103";
    /**
     * 目录层次已达到上限：新增目录时，当目录层级大于等于5时
     */
    String ADD_CATALOG_ERROR = "30104";
    /**
     * 目录不存在
     */
    String DIRECTORY_IS_NULL = "30105";
    /**
     * 数据目录删除错误:对数据目录进行删除出现的错误
     */
    String DEL_CATALOG_ERROR = "30200";
    /**
     * 初始化目录不可删除:初始化目录不可删除
     */
    String DELETE_INIT_CATALOG_ERROR = "30201";
    /**
     * 数据目录修改错误:对数据目录进行修改出现的错误
     */
    String MODIFY_CATALOG_ERROR = "30300";
    /**
     * 修改目录失败，名称重复:同一目录下，目录名称不可重复
     */
    String MODIFY_CATALOG_NAME_REPETION = "30301";
    /**
     * 只能移动到同类型目录下:移动目录时，只能移动到同类型目录下
     */
    String MODIFY_CATALOG_CATEGORY_ERROR = "30302";
    /**
     * 初始化目录不可修改:初始化目录不可修改
     */
    String MODIFY_INIT_CATALOG_ERROR = "30303";
    /**
     * 该节点不可移动:移动不可移动的节点时
     */
    String MODIFY_CATALOG_NODE_ERROR = "30304";

    /**
     * 同一目录下描述不可重复
     */
    String DIRECTORY_DESC_REPECT = "30305";

    /**
     * 本地数据源内部错误:对本地数据源进行增删改查时出现的错误
     */
    String LOCAL_DATASOURCE_ERROR = "30400";
    /**
     * 新增数据源错误	:新增数据源出现的错误
     */
    String ADD_DATASOURCE_ERROR = "30401";
    /**
     * 数据源名称重复	:新增数据源时，名称重复
     */
    String ADD_DATASOURCE_NAME_REPETION = "30402";
    /**
     * 数据源信息不完整:新增数据源时，数据源信息不完整
     */
    String DATASOURCE_INFO_INCOMPLETE = "30403";
    /**
     * ip、端口重复:添加数据源时，ip、端口重复
     */
    String ADD_DATASOURCE_IP_PORT_REPETION = "30404";
    /**
     * 修改数据源错误:修改数据源时出现的错误
     */
    String MODIFY_DATASOURCE_ERROR = "30405";
    /**
     * 数据源名称重复:修改数据源时，名称重复
     */
    String MODIFY_DATASOURCE_NAME_REPETION = "30406";
    /**
     * 数据源ip端口重复:修改数据源时，ip端口重复
     */
    String MODIFY_DATASOURCE_IP_PORT_REPETION = "30407";
    /**
     * 数据源类型是非数据库
     */
    String DATASOURCETYPE_ISNOT_DATABASE = "30408";
    /**
     * 同一个数据源，表名称不能重复
     */
    String DATASOURCE_TABLENAME_IS_REPEAT = "30409";
    /**
     * 字段长度或小数点输入错误
     */
    String LENGTH_OR_SCALE_IS_ERR = "30410";
    /**
     * 字段长度超过最大值
     */
    String LENGTH_IS_TOOBIG = "30411";
    /**
     * 数据源删除失败:数据源删除失败
     */
    String DELETE_DATASOURCE_EXCEPTION = "30412";
    /**
     * 数据源删除失败:数据源已关联其他实体，不能删除
     */
    String DELETE_DATASOURCE_BIND_EXCEPTION = "30413";
    /**
     * 本地服务获取topic失败
     */
    String GET_TOPICS_EXCEPTION = "30414";
    /**
     * 数据池级联接收方通知数据交换平台失败
     */
    String CASCADE_NOTIFY_ERROR = "30501";
    /**
     * 数据池级联跨网摆渡失败
     */
    String CASCADE_SEND_ERROR = "30502";
    /**
     * 级联池注册失败
     */
    String CASCADE_REGISTER_FAILED = "30503";
    /**
     * 级联池已经存在
     */
    String CASCADE_ALREADY_EXISTS = "30504";
    /**
     * 级联池目录信息推送失败
     */
    String CASCADE_POOL_SCHEMA_PUSH_FAILED = "30505";
    /**
     * ETL中传入的数据库类型未支持
     */
    String DATASOURCE_TYPE_NOSUPPORT_ETL = "30601";
    /**
     * kettle文件创建错误
     */
    String KETTLE_FILE_CREATE_ERROR = "30602";
    /**
     * 不支持的同步来源类型
     */
    String SYNC_SOURCE_TYPE_NOSUPPORT = "30603";
    /**
     * 传入参数错误
     */
    String PARAM_ERROR = "30604";
    /**
     * 不支持的同步类型
     */
    String SYNC_TYPE_NOT_SUPPORT = "30605";
    /**
     * 建表异常:用于数据同步时处理新建表异常
     */
    String CREATA_TABLE_ERROR = "30700";
    /**
     * 表名已存在:建新表时，表名已存在
     */
    String TABLE_NAME_REPEAT = "30701";
    /**
     * 表名不能为空:建新表时，表名空
     */
    String TABLE_NAME_EMPTY = "30702";
    /**
     * 表描述已存在:建新表时，表描述已存在
     */
    String TABLE_DESC_REPEAT = "30703";
    /**
     * 表描述不能为空:建新表时，表描述空
     */
    String TABLE_DESC_EMPTY = "30704";

    /**
     * 同步任务时，任务中心处理失败
     */
    String SYNC_SAVE_ERROR = "30705";

    /**
     * 同步任务时，任务中心处理失败
     */
    String SYNC_QUERY_OBJECT_EMPTY = "30706";

    /**
     * 表字段格式不对
     */
    String FIELD_FORMAT_ERROR = "30707";

    //TODO: 20801
    // return
    /**
     * 复制一个草稿模型失败:复制一个草稿模型并返回id时失败
     */
    String CLONE_DRAFT_MODEL_ERROR = "30801";
    /**
     * 绑定的标签需设定外键:关联表存在主表时标签缺少外键
     */
    String FOREIGN_KEY_LACK = "30802";
    /**
     * 发布草稿模型失败:发布已存在当前版本的草稿模型失败
     */
    String RELEASE_DRAFT_MODEL_ERROR = "30803";
    /**
     * 导入已有模型及自动关联失败:导入级联模型的标签，并绑定关联关系失败
     */
    String IMPORT_CASCADE_MODEL_ERROR = "30804";
    /**
     * 添加计算规则失败:添加计算规则失败
     */
    String ADD_CALCULATE_RULE_ERROR = "30805";
    /**
     * 查询模型对应的计算规则失败:查询模型对应的计算规则失败
     */
    String QUERY_CALCULATES_ERROR = "30806";
    /**
     * 查询计算规则的详细信息失败:查询计算规则的详细信息失败
     */
    String QUERY_CALCULATE_ERROR = "30807";
    /**
     * 删除计算规则失败:删除计算规则失败
     */
    String DELETE_CALCULATE_ERROR = "30808";
    /**
     * 查询模型已添加的关联表失败:查询模型已添加的关联表失败
     * queryTableByModelId
     */
    String QUERY_BINDED_TABLE_ERROR = "30809";
    /**
     * 查询该模型某表的参数失败:查询该模型某表的参数失败（包含该表原来的列和已存在计算规则的输出参数）
     */
    String QUERY_BINDED_TABLE_PARAM_ERROR = "30810";
    /**
     * 修改计算规则的相关信息失败:修改计算规则的相关信息失败
     */
    String MODIFY_CALCULATE_INFO_ERROR = "30811";
    /**
     * 分页查找分类下的标签失败:分页查找分类下的标签失败
     */
    String QUERY_CLASSIFIED_TAGS_ERROR = "30812";
    /**
     * 标签属性不能存在空:建新标签时，标签属性不能存在空
     */
    String TAG_PARAM_EMPTY = "30813";
    /**
     * 在目录下创建标签失败:在目录下创建标签失败
     */
    String CREATE_CATALOG_TAG_ERROR = "30814";
    /**
     * 批量导入标签和码表失败:批量导入标签和码表失败
     */
    String BATCH_IMPORT_TAG_CODETABLE_ERROR = "30815";
    /**
     * 下载可批量导入标签的模板失败:下载可批量导入标签的模板失败
     */
    String DOWNLOAD_EXCEL_ERROR = "30816";
    /**
     * 唯一键必须关联主表
     */
    String MODEL_UNIQUE_MAIN_TABLE_ERROR = "30817";
    /**
     * 不存在主表时，唯一键必须关联所有关联表的字段
     */
    String MODEL_UNIQUE_BIND_TABLE_ERROR = "30818";
    /**
     * 时间依据必须关联应用标签的所关联的所有表
     */
    String MODEL_TIME_RULE_BIND_ERROR = "30819";
    /**
     * 导入标签已存在，但是标签中文名和英文名不一致
     */
    String TAG_BATCH_IMPORT_NAME_ERROR = "30820";
    /**
     * 标签类型未定义或非法
     */
    String TAG_BATCH_IMPORT_TYPE_ERROR = "30821";
    /**
     * 标签的目录不存在
     */
    String TAG_BATCH_IMPORT_DIR_ERROR = "30822";
    /**
     * 码表转换前的值不能重复
     */
    String REPEAT_TCODE_VALUE = "30823";
    /**
     * 标签已经绑定不能删除
     */
    String TAG_BIND_DELETE_ERROR = "30824";
    /**
     * 导入文件格式异常
     */
    String ERROR_FILE_TYPE = "30825";
    /**
     * 执行.sql文件失败
     */
    String EXECUTE_SQL_FILE_ERROR = "30826";
    /**
     * .sql文件不存在
     */
    String NO_SQL_FILE = "30827";
    /**
     * .sql文件处理失败
     */
    String DEAL_SQL_FILE_ERROR = "30828";
    /**
     * 模型必须设置唯一标志
     */
    String MODEL_MUST_PKEY = "30829";
    /**
     * 存在主表必须设置外键
     */
    String MAIN_TABLE_NEED_FKEY = "30830";
    /**
     * 标签导入存在失败记录，详见日志
     */
    String TAG_IMPORT_ERROR_READ_LOG = "30831";
    /**
     * 模型必须绑定来源表
     */
    String MUST_BIND_TABLE = "30832";
    /**
     * 标签英文名已存在
     */
    String TAG_ENGLISH_NAME_EXISTS = "30833";
    /**
     * 标签中文名已存在
     */
    String TAG_CHINESE_NAME_EXISTS = "30834";
    /**
     * 该模型中此标签已存在
     */
    String TAG_HAVE_EXISTS = "30835";
    /**
     * 关联键必须关联所有来源表
     */
    String FOREIGN_KEY_MUST_BIND_ALL_TABLE = "30836";
    /**
     * 存在主表，附表需要都设置关联键
     */
    String MAINTABLE_EXIST_ALL_AUXILIARY_TABLE_NEED_ASSOKEY = "30837";
    /**
     * 不存在主表，所有表必须设置关联键，且绑定同一个标签
     */
    String NO_MAINTABLE_NEED_BIND_SAME_TAG = "30838";
    /**
     * 必须添加至少一个标签
     */
    String AT_LEAST_ADD_ONE_TAG = "30839";
    /**
     * 导入模型已存在
     */
    String MODEL_HAS_EXISTS = "30840";
    /**
     * 该关系已经存在
     */
    String RELATION_EXISTS = "30841";
    /**
     * 已经使用的关系不能删除
     */
    String USED_RELATION_CANNOT_DELETE = "30842";
    /**
     * 文本标签名称不能为空
     */
    String TEXTTAG_NAME_CANNOT_NULL = "30843";
    /**
     * 任务中心未执行成功的关系模型才能删除
     */
    String TASKCENTER_ERROR_RELATION_CAN_DELETE = "30844";
    /**
     * 小数的精度设置需要小于长度
     */
    String PRECISION_MUST_LESS_LENGTH = "30845";
    /**
     * id对应的关系定义不存在
     */
    String RELATION_NOT_EXISTS = "30846";
    /**
     * 不能添加相同的关系模型
     */
    String FORBID_SAVE_SAME_RELATION = "30847";
    /**
     * 标签长度不能为零
     */
    String FORBID_TAG_LENGTH_ZERO = "30848";
    /**
     * 文本标签长度最大为32个字符
     */
    String TEXTTAG_MAX_LENGTH_32 = "30849";
    /**
     * 读取excel文件出错
     */
    String TAG_EXCEL_ERROR = "30850";
    /**
     * 来源增量字段为空
     */
    String SYNC_CONF_INCREMENTATTR_IS_EMPTY = "30851";

    /**
     * 绑定标签类型错误
     */
    String BANING_TAG_TYPE_ERROR = "30852";
    /**
     * datai删除任务失败
     */
    String DATAI_DELETE_TASK_ERROR = "30853";
    /**
     * 文本标签正则匹配失败，不能包含特殊字符@#$%^&*
     */
    String TEXT_TAG_REGEX_ERROR = "30854";
    /**
     * 文本标签表不能删除
     */
    String TEXT_TAG_CAN_NOT_DELETE = "30855";
    /**
     * 关系名称已经存在
     */
    String RELATION_NAME_EXISTS = "30856";
    /**
     * 关系模型名称已经存在
     */
    String RELATION_ENTITY__NAME_EXISTS = "30857";
    /**
     * 查询标签详情时标签code不能为空
     */
    String QUERY_TAG_MUST_CODE = "30858";
    /**
     * 此标签不存在，请先创建文本标签
     */
    String TEXT_TAG_DONT_EXISTS = "30859";
    /**
     * 该记录已经存在此文本标签
     */
    String SAME_TAG_EXIST_IN_RECORD = "30860";
    /**
     * 打标签请求参数错误：文本标签值TextTagValue不能为空
     */
    String TEXTTAGVALUE_CANT_EMPTY = "30861";
    /**
     * 打标签请求参数错误：唯一标识UniqueKeys不能为空
     */
    String UNIQUEKEYS_CANT_EMPTY = "30862";
    /**
     * 打标签请求参数错误：唯一标识数值UniqueValues不能为空
     */
    String UNIQUEVALUES_CANT_EMPTY = "30863";
    /**
     * 打标签请求参数错误：实体代码code不能为空
     */
    String ENTITY_CODE_CANT_EMPTY = "30864";
    /**
     * 打标签请求参数错误：实体版本version不能为空
     */
    String ENTITY_VERSION_CANT_EMPTY = "30865";
    /**
     * 打标签请求参数错误：待修改对像updateTag不能为空
     */
    String UPDATETAG_CANT_EMPTY = "30866";
    /**
     * 打标签请求参数错误：待修改字段名tagKey不能为空
     */
    String UPDATETAG_KEY_CANT_EMPTY = "30867";
    /**
     * 打标签请求参数错误：待修改字段值tagValue不能为空
     */
    String UPDATETAG_VALUE_CANT_EMPTY = "30868";
    /**
     * 已经被关系模型使用的实体不可删除
     */
    String USEINGBY_RELATION_CANT_DELETE = "30869";
    /**
     * 平台描述最长127个字符
     */
    String DESC_TOO_LONG = "30870";
    /**
     * 码表的输入值不能有重复
     */
    String TABLECODE_FORBID_SAME_IMPOT = "30871";
    /**
     * 计算字段个数必须相等
     */
    String CACULATE_FIELDS_MUST_EQUAL = "30872";
    /**
     * 关系建模定义关系时俩唯一键不能存在为空:关系建模定义关系时俩唯一键不能存在为空
     */
    String MAPPING_CALCULATE_UNIQUEKEY_PARAM_NULL = "20880";

    /**
     * 关系建模时同值计算参数类型错误:关系建模时同值计算参数类型错误
     */
    String MAPPING_CALCULATE_SAMEVALUE_TYPE_ERROR = "20881";

    /**
     * 关系检索时入参存在空:关系检索时入参存在空
     */
    String MAPPING_GENERATE_RELATIONCODE_PARAM_NULL = "20882";
    /**
     * 替换不能删除原标签
     */
    String REPLACE_CANNOT_CHANGE_OLD_FIELD = "20883";

    /**
     * 同步参数错误
     */
    String SYNC_PARAM_ERROR = "30901";

    /**
     * 更新(重置)基准库参数操作错误
     */
    String BASE_PARAM_ERROR = "31001";

    /**
     * 基准库参数ID为空错误
     */
    String BASE_ID_EMPTY_ERROR = "31002";
    /**
     * 查询实体不存在
     */
    String ENTITY_NOT_EXISTS = "31003";
    /**
     * 拼装sql失败
     */
    String CREATE_SQL_ERROR = "31004";

    /**
     * 数据订阅删除失败
     */
    String DELETE_SUBSCRIBE_FAILURE = "31005";

    /**
     * 实体对象为空
     */
    String DATA_SERVER_OBJECT_EMPTY = "31006";

    /**
     * 查询treeId为空
     */
    String DATA_SERVER_QUERY_TREE_ID_EMPTY = "31007";

    /**
     * entityId为空
     */
    String DATA_SERVER_ENTITY_ID_EMPTY = "31008";

    /**
     * registerId为空
     */
    String DATA_SERVER_REGISTER_ID_EMPTY = "31009";

    /**
     * subscribeId为空
     */
    String DATA_SERVER_SUBSCRIBE_ID_EMPTY = "31010";

    /**
     * taskName为空
     */
    String DATA_SERVER_TASK_NAME_EMPTY = "31011";

    /**
     * ip为空
     */
    String DATA_SERVER_IP_EMPTY = "31012";

    /**
     * ip不合法
     */
    String DATA_SERVER_IP_INVALID = "31013";

    /**
     * PORT为空
     */
    String DATA_SERVER_PORT_EMPTY = "31014";

    /**
     * PORT不合法
     */
    String DATA_SERVER_PORT_INVALID = "31015";

    /**
     * 订阅方式为空
     */
    String DATA_SERVER_SUB_WAY_EMPTY = "31016";

    /**
     * 表结构code为空
     */
    String DATA_SERVER_TABLE_STRUCT_CODE_EMPTY = "31017";

    /**
     * 注册名称为空
     */
    String DATA_SERVER_REGISTER_NAME_EMPTY = "31018";

    /**
     * 注册名称已存在
     */
    String DATA_SERVER_REGISTER_NAME_EXITS = "31019";

    /**
     * 实体code为空
     */
    String DATA_SERVER_ENTITY_CODE_EMPTY = "31020";

    /**
     * 实体code已存在
     */
    String DATA_SERVER_ENTITY_CODE_EXITS = "31021";

    /**
     * 任务名称已存在
     */
    String DATA_SERVER_TASK_NAME_EXITS = "31022";

    /**
     * 源表结构信息为空
     */
    String DATA_SERVER_KAFKA_TABLE_STRUCT_EMPTY = "31023";

    /**
     * 数据源信息为空
     */
    String DATA_SERVER_SOURCE_INFO_EMPTY = "31024";

    /**
     * 来源类型为空
     */
    String DATA_SERVER_SOURCE_TYPE_EMPTY = "31025";

    /**
     * 关联实体版本号为空
     */
    String DATA_SERVER_ENTITY_VERSION_EMPTY = "31026";
    /**
     * 参数校验错误
     */
    String DATA_SERVER_PARAM_ERROR = "31027";
    /**
     * 单页查询数量必须大于0小于等于10000
     */
    String DATA_SERVER_PARAM_SIZE_ERROR = "31028";
    /**
     * 单实体查询失败
     */
    String DATA_SERVER_QUERY_OBJECT_FAIL = "31029";

    /**
     * 服务注册路径path为空
     */
    String DATA_SERVER_REGISTER_PATH_EMPTY = "31030";

    /**
     * 服务注册路径path已存在
     */
    String DATA_SERVER_REGISTER_PATH_EXISTS = "31031";

    /**
     * 实体查询权限未配置
     */
    String DATA_SERVER_ENTITY_QUERY_NOT_CONFIG = "31032";
    /**
     * 返回字段权限不够
     */
    String DATA_SERVER_RETURN_COLUMN_NOT_PERMISSION = "31033";
    /**
     * 查询条件字段权限不够
     */
    String DATA_SERVER_QUERY_COLUMN_NOT_PERMISSION = "31034";
    /**
     * 排序权限未配置
     */
    String DATA_SERVER_SORT_NOT_CONFIG  = "31035";
    /**
     * 排序字段权限不够
     */
    String DATA_SERVER_SORT_COLUMN_NOT_PERMISSION = "31036";

    /**
     * 服务注册tree路径path为空
     */
    String DATA_SERVER_TREE_PATH_EMPTY = "31037";

    /**
     * 返回字段列为空
     */
    String DATA_SERVER_RETURN_COLUMN_EMPTY = "31038";

    /**
     * 查询条件列为空
     */
    String DATA_SERVER_QUERY_COLUMN_EMPTY = "31039";

    /**
     * 排序列为空
     */
    String DATA_SERVER_SORT_COLUMN_EMPTY = "31040";

    /**
     * 经纬度值解析异常
     */
    String LONGITUDE_LATITUDE_VALUE_PARSE_ERROR = "31041";
    /**
     * 经纬度名称解析异常
     */
    String LONGITUDE_LATITUDE_NAME_PARSE_ERROR = "31042";

    /**
     * 实体类型为空
     */
    String DATA_SERVER_ENTITY_TYPE_EMPTY = "31043";

    /**
     * 调用任务中心接口失败
     */
    String DATA_SERVER_TASK_CENTER_EXCEPTION = "31044";

    /**
     * in条件数据解析异常
     */
    String DATA_QUERY_CONDITION_PARSE_EXCEPTION = "31045";

    /**
     * 注册服务生成接口文档失败
     */
    String DATA_SERVER_TO_INTERFACE_DOCUMENT_FAIL = "31046";

    /**
     * 查询注册服务为空
     */
    String DATA_SERVER_REGISTER_ENTITY_EMPTY = "31047";
    /**
     * 创建视图失败
     */
    String DATA_SERVER_CREATE_VIEW_ERROR = "31048";
    /**
     * 删除视图失败
     */
    String DATA_SERVER_DELETE_VIEW_ERROR = "31049";
    /**
     * 查询视图失败
     */
    String DATA_SERVER_QUERY_VIEW_ERROR = "31050";
    /**
     * 处理视图发生其他异常
     */
    String DATA_SERVER_DEAL_VIEW_OTHER_ERROR = "31051";
    /**
     * not exists查询时所传参数中表列名和视图列名个数不一致
     */
    String DATA_SERVER_QUERY_VIEW_TABLE_NAME_NUM_NOT_SAME = "31052";
    /**
     * not exists查询时所传参数中表或者视图列名为空
     */
    String DATA_SERVER_QUERY_VIEW_TABLE_NAME_IS_EMPTY = "31053";
    /**
     * not exists查询时所传参数中table_code为空
     */
    String DATA_SERVER_QUERY_TABLE_CODE_BLANK = "31054";
    /**
     * FieldOption中的type参数不对，不在允许的操作符内
     */
    String DATA_SERVER_QUERY_ORERATOR_ERROR = "31055";

    /**
     * 当用sql注册服务时，complexsql不能为空
     */
    String DATA_SERVER_REGISTER_COMPLEXSQL_BLANK = "31056";
    /**
     * 当用sql注册服务时， 用户书写sql执行失败
     */
    String DATA_SERVER_REGISTER_VALID_SQL_FAIL = "31057";
    /**
     * 当调用用sql注册服务时，请求参数不在配置参数范围内
     */
    String DATA_SERVER_REGISTER_REQUEST_PARAMS_FAIL = "31058";
    /**
     * sql服务注册时，只能进行select操作, 不能包含update或delete等更改数据库的关键字
     */
    String DATA_SERVER_REGISTER_CONTAIN_NOT_SELECT = "31059";

    String DATA_SERVER_ENTITY_TYPE_ERROR = "31060";

    /**
     * 该视图被服务注册引用
     */
    String DATA_SERVER_DELETE_VIEW_COUNTS_NOT_ZERO = "31061";
    /**
     * 视图名称已存在
     */
    String DATA_SERVER_CREATE_VIEW_ALREADY_EXIST = "31062";

    /**
     * 数据查询功能删除id为空
     */
    String DATA_SERVER_QUERY_CONFIG_DELETE_ID_EMPTY = "31063";

    /**
     * 数据查询功能不存在
     */
    String DATA_SERVER_QUERY_CONFIG_UPDATE_ID_EMPTY = "31064";

    /**
     * 功能查询参数为空
     */
    String DATA_SERVER_QUERY_CONFIG_QUERY_PARAM_EMPTY = "31065";

    /**
     * 功能查询分页参数不合法
     */
    String DATA_SERVER_QUERY_CONFIG_PAGE_PARAM_ERROR = "31066";

    /**
     * 功能详情查询id为空
     */
    String DATA_SERVER_QUERY_CONFIG_DETAIL_ID_EMPTY = "31067";

    /**
     * 查询配置请求参数为空
     */
    String DATA_SERVER_QUERY_CONFIG_REQUEST_EMPTY = "31068";

    /**
     * 数据查询请求参数不合法
     */
    String DATA_SERVER_QUERY_DATA_REQUEST_PARAM_ILLEGAL = "31069";

    /**
     * 数据查询关联表信息不存在
     */
    String DATA_SERVER_QUERY_DATA_ENTITY_ATTRIBUTE_EMPTY = "31070";

    /**
     * 数据查询导出图片失败
     */
    String DATA_SERVER_QUERY_DATA_EXPORT_PICTURE_FAILED = "31071";

    /**
     * 数据查询名称重复
     */
    String DATA_SERVER_QUERY_DATA_CONFIG_NAME_REPEAT = "31072";

    /**
     * 地图服务ip、端口为空
     */
    String DATA_SERVER_QUERY_DATA_MAP_SERVER_EMPTY = "31073";

    /**
     *  数据查询结果导出失败
     */
    String DATA_SERVER_QUERY_DATA_EXPORT_FAIL = "31074";

    /**
     * 数据查询功能信息为空
     */
    String DATA_SERVER_QUERY_CONFIG_EMPTY = "31075";

    /**
     * 数据查询功能名称为空
     */
    String DATA_SERVER_QUERY_CONFIG_NAME_EMPTY = "31076";

    /**
     * 数据查询配置关联表code为空
     */
    String DATA_SERVER_QUERY_CONFIG_TABLE_ID_EMPTY = "31077";

    /**
     * 注册服务保存失败
     */
    String DATA_SERVER_REGISTER_SAVE_FAIL =  "31078";

    /**
     * 文本标签信息不存在
     */
    String DATA_SERVER_QUERY_TEXT_TAG_TABLE_NULL =  "31079";

    /**
     * 无该表信息
     */
    String DATA_SERVER_TABLE_INFO_EMPTY = "31080";

    /**
     * 未包含{0}等实体唯一键
     */
    String DATA_SERVER_ENTITY_LACK_UNIQUEKEY = "31081";

    /**
     * {0}等视图被引用，无法删除
     */
    String DATA_SERVER_VIEWS_ARE_USED = "31082";
    /**
     * 从连接池获取数据源连接失败
     */
    String DATA_SERVER_GET_CONNECTION_FROM_POOL = "31083";
    /**
     * 表类型错误,无法获取该表信息
     */
    String DATA_SERVER_GET_TABLE_INFO_ERROR = "31084";
    /**
     * 把某列josn格式的值转为对象失败
     */
    String DATA_SERVER_TRANSFORM_QUERY_COLUMN_FAIL = "31085";



    /**
     * 实体信息不完善
     */
    String TABLEENTITY_IMCOMLETE = "31101";

    //平台初始化模块定义
    /**
     * 用户名称不能为空
     */
    String USER_NAME_NULL = "31201";
    /**
     * 用户密码不能为空
     */
    String USER_PASSWORD_NULL = "31202";
    /**
     * Datai的IP不能为空
     */
    String DATAI_IP_NULL = "31203";
    /**
     * Datai端口不能为空
     */
    String DATAI_PORT_NULL = "31204";
    /**
     * 平台编码不能为空
     */
    String POOL_INDEX_CODE_NULL = "31205";
    /**
     * 平台IP不能为空
     */
    String POOL_IP_NULL = "31206";
    /**
     * 平台名称不能为空
     */
    String POOL_NAME_NULL = "31207";
    /**
     * 平台标志不能为空
     */
    String POOL_GENRE_NULL = "31208";
    /**
     * 平台端口不能为空
     */
    String POOL_PORT_NULL = "31209";
    /**
     * 用户名已存在异常:用户名已存在
     */
    String USER_EXIST_EXCEPTION = "31210";

    /**
     * 用户名或密码为空
     */
    String USERNAME_OR_PWD_IS_NULL = "31301";

    /**
     * 用户保存失败
     */
    String USER_SAVE_FAIL = "31302";

    /**
     * 登陆失败
     */
    String LOGIN_FAIL = "31303";

    /**
     * 盐为空
     */
    String SALT_IS_NULL = "31304";

    /**
     * 验证码不正确
     */
    String VALIDATE_IS_ERROR = "31305";

    /**
     * 账号已被锁定，15分钟后再登录
     */
    String USER_IS_LOCK = "31306";

    /**
     * 管理员用户不能删除
     */
    String USER_IS_CANT_DELETE = "31307";
    /**
     * 用户不存在
     */
    String USER_IS_NOT_EXIST = "31308";

    /**
     * 密码错误
     */
    String PWD_IS_ERROR = "31309";

    /**
     * 密码错误3次，该账号还有2次输入机会
     */
    String PWD_IS_ERROR_THREE = "31310";

    /**
     * 密码错误4次，该账号还有1次输入机会
     */
    String PWD_IS_ERROR_FOUR = "31311";
    /**
     * 密码错误5次，账号已被锁定，15分钟后再登录
     */
    String PWD_IS_ERROR_FIVE = "31312";

    /**
     * 角色名为空
     */
    String ROLENAME_IS_NULL = "31401";

    /**
     * 管理员角色不能删除
     */
    String ROLE_IS_CANT_DELETE = "31402";

    /**
     * 删除表失败:该数据已添加同步任务，请先删除同步任务==========
     */
    String DETELE_TABLE_SYNC_EXCEPTION = "31501";

    /**
     * 删除表失败:该数据已添加建模任务，请先删除建模任务
     */
    String DETELE_TABLE_MODEL_EXCEPTION = "31502";

    /**
     * 删除表失败:该数据已添加数据订阅，请先删除数据订阅
     */
    String DETELE_TABLE_REGISTER_EXCEPTION = "31503";

    /**
     * 原始表取消关联:原始表数据不存在
     */
    String RELATED_ORIGINAL_TABLE_EXCEPTION = "31504";

    /**
     * 该公钥失效，请重新获取
     */
    String PUBLICKEY_IS_FAIL = "31505";

    /**
     * 生成公钥私钥失败
     */
    String INITKEY_IS_FAIL = "31506";

    /**
     * 解密失败
     */
    String DECRYPT_IS_FAIL = "31507";
    /**
     * 公钥为空
     */
    String PUBLICKEY_IS_NULL = "31508";

    /**
     * 树ID不能为空
     */
    String TREEID_IS_NULL = "31601";

    /**
     * 树ID,表ID不是个正整数
     */
    String TREEID_AND_ID_IS_ERROR = "31602";

    /**
     * 树ID不正确
     */
    String TREEID_ID_IS_ERROR = "31603";

    /**
     * 表ID,树ID不能为空
     */
    String TREEID_AND_ID_IS_NULL = "31604";

    /**
     * 索引规模过大,建议减少索引数量
     */
    String INDEX_TOO_LARGE = "31605";

    /**
     * 该表正在被使用,请稍后重试
     */
    String TABLE_IS_USED = "31606";

    /**
     * 用户登录失败,用户名和密码错误:用户通过用户名和密码登录,服务端验证用户名或者密码错误,拒绝该用户登录。
     */
    String LOGIN_FAILED_USERNAME_PASSWORD_ERROR = "40001";
    /**
     * 服务认证失败,用户名和密码错误:服务之间访问需要身份认证，服务请求端采用用户名和密码的认证方式，服务应答端验证用户名或者密码错误,拒绝访问。
     */
    String SERVICE_AUTHENTICATION_FAILED_USERNAME_PASSWORD_ERROR = "40002";
    /**
     * 服务认证失败,令牌错误:服务之间访问需要身份认证，服务请求端采用令牌的认证方式，服务应答端验证令牌不合法,拒绝访问
     */
    String SERVICE_AUTHENTICATION_FAILED_TOKEN_ERROR = "40003";
    /**
     * 服务认证失败,证书错误:服务之间访问需要身份认证，服务请求端采用数字证书的认证方式，服务应答端验证证书不合法,拒绝访问。
     */
    String SERVICE_AUTHENTICATION_FAILED_CERTIFICATE_ERROR = "40004";
    /**
     * 访问权限不足:请求端访问具有权限控制的资源，服务端验证该请求者无访问该资源的权限,拒绝访问。
     */
    String ACCESS_PERMISSION_NONE = "40005";
    /**
     * 端口侦听失败:服务端监听端口失败，包括创建socket、绑定socket、监听socket等任意环节的失败或异常。
     */
    String PORT_LISTEN_FAILED = "40101";
    /**
     * 连接远程服务失败:客户端连接远程服务失败，包括创建socket、socket连接等任意环节的失败或异常。
     */
    String CONNECT_REMOTE_SERVICE_FAILED = "40102";
    /**
     * 会话过期:具有状态的连接，服务端验证客户端的连接会话已过期。
     */
    String SESSION_EXPIRATION = "40103";
    /**
     * 周期修改失败:数据资源平台周期修改失败时的错误提示
     */
    String UPDATE_CYCLEINFO_EXCEPTION = "40104";
    /**
     * 周期修改失败:原周期不存在或者周期类型不存在
     */
    String CYCLEINFO_OR_CYCLETYPE_NOT_EXIST = "40105";
    /**
     * 任务删除失败:任务不存在或任务删除失败
     */
    String DELETE_TASK_EXCEPTION = "40106";
    /**
     * 任务不存在异常：任务不存在异常
     */
    String TASK_NOT_EXIST_EXCEPTION = "40107";
    /**
     * 任务存在异常：任务已存在
     */
    String TASK_EXIST_EXCEPTION = "40108";
    /**
     * 任务执行异常：任务执行失败
     */
    String TASK_EXECUTE_EXCEPTION = "40109";
    /**
     * 任务创建失败：任务创建失败
     */
    String TASK_CREATE_EXCEPTION = "40110";
    /**
     * 任务预览失败：暂无该任务详情
     */
    String TASK_PREVIEW_EXCEPTION = "40111";
    /**
     * 数据库连接失败:访问数据库时，与数据库建立连接失败。
     */
    String DATABASE_CONNECTION_FAILED = "40201";
    /**
     * 数据库驱动加载失败:检查数据库驱动是否安装,版本是否正确。
     */
    String DATABASE_DRIVEN_LOAD_FAILED = "40202";
    /**
     * 数据库访问权限不足:访问数据库时因权限不足导致访问失败。
     */
    String DATABASE_PERMISSION_NONE = "40203";
    /**
     * 数据库执行失败:访问数据库时除权限不足以外的原因导致访问失败。
     */
    String DATABASE_EXECUTE_FAILED = "40204";
    /**
     * 数据库响应超时:访问数据库响应超时。
     */
    String DATABASE_RESPONSE_TIMEOUT = "40205";
    /**
     * 数据库用户或密码错误:访问数据库的用户或密码错误
     */
    String DATABASE_USER_OR_PASSWORD_ERROR = "40206";

    /**
     * 唯一键冲突:数据库插入时唯一键冲突
     */
    String DATABASE_DUPLICATEKEY_CONFLICT_ERROR = "40207";

    /**
     * 资源加载失败:文件打开失败、加载dll（so）文件失败。
     */
    String LOAD_RESOURCE_FAILED = "40301";
    /**
     * 资源卸载失败:文件关闭失败、卸载dll（so）文件失败。
     */
    String UNINSTALL_RESOURCE_FAILED = "40302";
    /**
     * 创建资源失败:创建文件失败、创建句柄失败、创建线程失败。
     */
    String CREATE_RESOURCE_FAILED = "40303";
    /**
     * 访问资源失败:写文件失败、访问句柄失败、启动线程失败。
     */
    String ACCESS_RESOURCE_FAILED = "40304";
    /**
     * 删除资源失败:删除文件失败、释放句柄失败、停止线程失败。
     */
    String DELETE_RESOURCE_FAILED = "40305";

    /**
     * 请求错误（语义有误或者请求参数有误）:1）语义有误，当前请求无法被服务器理解。除非进行修改，否则客户端不应该重复提交这个请求。 2）请求参数有误。
     */
    String REQUEST_ERROR = "41400";
    /**
     * 当前请求需要用户验证:该响应必须包含一个适用于被请求资源的 WWW-Authenticate
     * 信息头用以询问用户信息。客户端可以重复提交一个包含恰当的 Authorization 头信息的请求。如果当前请求已经包含了
     * Authorization 证书，那么401响应代表着服务器验证已经拒绝了那些证书。
     */
    String CURRENT_REQUEST_REQUIRES_USER_AUTHENTICATION = "41401";
    /**
     * 指定的请求方法不能被用于请求相应的资源:请求行中指定的请求方法不能被用于请求相应的资源。
     */
    String REQUEST_METHOD_CAN_NOT_ACCESS_RESOURCE = "41405";
    /**
     * 请求的资源的内容特性无法满足请求头中的条件，因而无法生成响应实体:请求的资源的内容特性无法满足请求头中的条件，因而无法生成响应实体。
     */
    String GENERATE_REPONSE_ENTITY_FAILED = "41406";
    /**
     * 客户端必须在代理服务器上进行身份验证:客户端必须在代理服务器上进行身份验证。代理服务器必须返回一个 Proxy-Authenticate
     * 用以进行身份询问。
     */
    String CLIENT_MUST_AUTHENTICATE_ON_PROXY_SERVER = "41407";
    /**
     * 请求超时:客户端没有在服务器预备等待的时间内完成一个请求的发送。客户端可以随时再次提交这一请求而无需进行任何更改。
     */
    String REQUEST_TIME_OUT = "41408";
    /**
     * 服务器拒绝在没有定义 Content-Length 头的情况下接受请求:服务器拒绝在没有定义 Content-Length 头的情况下接受请求。
     */
    String NO_CONTENT_LENGTH = "41411";
    /**
     * 服务器拒绝处理当前请求，因为该请求提交的实体数据大小超过了服务器愿意或者能够处理的范围:服务器拒绝处理当前请求，
     * 因为该请求提交的实体数据大小超过了服务器愿意或者能够处理的范围。
     */
    String ENTITY_DATA_TOO_BIG = "41413";
    /**
     * 请求的URI 长度超过了服务器能够解释的长度:请求的URI 长度超过了服务器能够解释的长度，因此服务器拒绝对该请求提供服务。
     */
    String URI_TOO_LONG = "41414";
    /**
     * 实体格式不支持:对于当前请求的方法和所请求的资源，请求中提交的实体并不是服务器中所支持的格式，因此请求被拒绝。
     */
    String ENTITY_FORMAT_NO_SUPPORT = "41415";
    /**
     * 服务器的连接数超过了服务器许可的最大范围:客户端请求连接，服务端判断当前所有连接数已经超过了服务器许可的最大范围。
     */
    String CONNECTION_NUMBER_EXCEEDS_MAXIMUM = "41421";
    /**
     * 请求格式正确，但是由于含有语义错误，无法响应:请求格式正确，但是由于含有语义错误，无法响应。
     */
    String REQUEST_SEMANTIC_ERROR = "41422";
    /**
     * beanutils 复制bean的时候报错
     */
    String BEAN_COPY_ERROR = "41423";
    /**
     * 数据源source_id为空
     */
    String SOURCE_ID_IS_EMPTY = "41424";

    /**
     * 配置文件信息配置有误或者未配置
     */
    String SYS_CONFIG_ERR = "41425";

    /**
     * 签名信息为空
     */
    String AUTHORIZATION_IS_NULL = "50001";

    /**
     * accessKey不存在
     */
    String ACCESSKEY_NOT_EXIST = "50002";

    /**
     * 签名错误
     */
    String AUTHORIZATION_WRONG = "50003";

    /**
     * 签名过程错误
     */
    String AUTHORIZATION_PROCESS_WRONG = "50004";
}
