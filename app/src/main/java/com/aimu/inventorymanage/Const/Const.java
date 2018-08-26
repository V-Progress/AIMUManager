package com.aimu.inventorymanage.Const;

public class Const {
    public static final String BMOB_APPID = "e71938f369d2088f62834f6648a3fe03";

    /**
     * 参数配置
     */
    public interface Config {
        String ROOT_DIR = "mobilelife";
        /** 网络访问IP */
//        String DOMAIN = BuildConfig.DOMAIN;
//        /** 文件上传IP */
//        String DOMAIN_UPLOAD = BuildConfig.DOMAIN_UPLOAD;
//        /** 是否从和包启动 */
//        boolean IS_START_FROM_AP = BuildConfig.IS_START_FROM_AP;
//        /** 是否打印日志到控制台 */
//        boolean IS_LOG = BuildConfig.IS_LOG;
        boolean IS_LOG = true;
//        /** 是否打印日志到文件 */
//        boolean IS_LOG_TO_FILE = BuildConfig.IS_LOG_TO_FILE;
//        /** 网络报文是否加密 */
//        boolean IS_ENC = BuildConfig.IS_ENC;
//        /** 是否是生产版本 */
//        boolean IS_PRO = BuildConfig.IS_PRO;
//        /** 是否一分测试 */
//        boolean IS_ONE_FEN = BuildConfig.IS_ONE_FEN;
    }
    /**
     * 日志TAG
     */
    public interface LogTag {
        /** 默认日志标签 */
        String TAG_DEFAULT = "AIMU";
        /** 卡交互类日志标签 */
        String TAG_APDU = "UMPAY_APDU";
        /** 网络请求类日志标签 */
        String TAG_HTTP = "UMPAY_HTTP";
        /** okhttp工具日志标签 */
        String TAG_OKHTTP = "UMPAY_OKHTTP";
    }

    public interface DB_KEY{
        String KEY_DB_WHERE = "user_phoneNum";
    }

}
