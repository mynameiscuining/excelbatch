package cn.njyazheng.util;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class Hash163 {

    public static final int DEFAULT_HASH_VAL = 6;


    public static final Hash163 SINGLE_HASH = new Hash163(1);

    public static final Hash163 DEFAULT_HASH = new Hash163(DEFAULT_HASH_VAL);


    public static final Hash163 EXPAND_HASH = new Hash163(12);

    private static final int[] LPOWER = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
            53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139,
            149, 151, 157, 163, 167, 173 };

    private static final int MAX_LEN = LPOWER.length;


    public static Hash163 newCustomHash(int hash) {
        Assert.isTrue(hash > 0, "Invalid hash value :" + hash);
        return new Hash163(hash);
    }

    private int hash;

    private Hash163(int hash) {
        this.hash = hash;
    }

    /**
     * 根据hash值 ，以List返回所有的可能Hash值
     *
     * @return 所有可能的hash值
     */
    public List<String> getHashsAsList() {
        List<String> hashList = new ArrayList<String>();
        for (int postfix = 0; postfix < hash; postfix++) {
            hashList.add(getHashStr(postfix));
        }
        return hashList;
    }

    /**
     * 返回string类型的hash
     *
     * @param hash
     * @return String类型的Hash值
     */
    private String getHashStr(int hash) {
        if (hash < 10) {
            return "0" + hash;
        }
        return String.valueOf(hash);
    }

    /**
     * 根据用户名获得HASH值
     *
     * @param str
     * @return int类型的hash值
     */
    private int hash(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            int realInd = i % MAX_LEN;
            sum += str.charAt(i) * LPOWER[realInd];
        }
        return sum % hash;
    }

    /**
     * @return java.lang.String
     * @param str
     *            java.lang.String
     */
    public String sHash(String str) {
        int sum = -1;
        sum = hash(str);
        if ((sum < 0) || (sum > hash - 1)) {
            throw new RuntimeException("Exception in method sHash of class Hash163:error");
        }
        return getHashStr(sum);
    }
}
