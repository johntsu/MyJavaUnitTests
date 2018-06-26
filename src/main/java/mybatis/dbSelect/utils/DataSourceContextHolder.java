package mybatis.dbSelect.utils;

public class DataSourceContextHolder {
	private static final ThreadLocal contextHolder = new ThreadLocal();    
    
    public static void setDbType(String dbType) {    
        contextHolder.set(dbType);    
    }    
    
    public static String getDbType() {    
        return ((String) contextHolder.get());    
    }    
    
    public static void clearDbType() {    
        contextHolder.remove();    
    }    
}
