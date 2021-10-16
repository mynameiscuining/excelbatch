package cn.njyazheng.util;



public class StringUtil {

    private StringUtil() {

    }

    /**
     * 判断String是否为null或者是否为空字符串
     *
     * @param string 判断的字符串
     * @return null或者空字符串返回true ;其他返回false
     */
    public static boolean isEmpty(String string) {
        return null == string || string.trim().equals("");
    }

    /**
     * 将目标字符串按照固定长度截断，不足长度的，以填充字符串在前面填充
     * @param src 原始字符串
     * @param len 需要的长度
     * @param padchar 填充字符
     * @return len 长度的字符串
     */
    public static String fixLenth(String src,int len,char padchar) {
//        String fullStr=Strings.padStart(src, len, padchar);
//        return fullStr.substring(fullStr.length()-len);
          return  null;
    }
}
