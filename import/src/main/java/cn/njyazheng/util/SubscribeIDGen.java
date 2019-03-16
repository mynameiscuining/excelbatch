package cn.njyazheng.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Random;

@Component
@Scope("singleton")
public class SubscribeIDGen {

    private static String prefix="sub";

    private static char[] numpool= ("0123456789abcdefghijklmnopqrstuvwxyz"
            + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();

    private static final Random RAND = new Random();

    @Value("${server.instanceid:01}")
    private String instanceid="01";

    /**
     * subc+1位+1位+4位实例编号+14位时间戳+8位随机数
     * @param subscriptionFlag 0存入定购关系表；1存入临时定购关系表
     * @param subscriptionType 0套餐；1产品；2节目。
     * @return
     */
    public String getSubscriptionID(String subscriptionFlag, String subscriptionType){
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append("c");
        sb.append(subscriptionFlag);
        sb.append(subscriptionType);
        sb.append(StringUtil.fixLenth(instanceid, 4, '0'));
        sb.append(StringUtil.fixLenth(Long.toHexString(System.currentTimeMillis()), 14, '0'));
        sb.append(generate(8));
        return sb.toString();
    }

    private String generate(int len) {
        StringBuilder gen = new StringBuilder();
        for (int i = 0; i < len; i++) {
            gen.append(numpool[RAND.nextInt(numpool.length)]);
        }
        return gen.toString();
    }

    public String subscribeID2Serno(String subscribeID){
        String num=Integer.toHexString(Integer.parseInt(subscribeID.substring(4,10)));
        String hexStamp=subscribeID.substring(10,24);
        String prefix= Base64.getEncoder().encodeToString(Hex.sHex2byte(num+hexStamp));
        String random=subscribeID.substring(24,32);
        return prefix+random;
    }

    public String serno2SubscribeID(String serno){
        String prefix=Hex.byte2HexString(Base64.getDecoder().decode(serno.substring(0,serno.length()-8)));
        String num=StringUtil.fixLenth(Long.parseLong(prefix.substring(0,prefix.length()-14),16)+"",6,'0');
        String stamp=prefix.substring(prefix.length()-14);
        String random=serno.substring(serno.length()-8);
        return "subc"+num+stamp+random;
    }
}
