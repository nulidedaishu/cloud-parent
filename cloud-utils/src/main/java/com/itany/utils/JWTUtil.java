package com.itany.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 *  JWT:通俗的说本质上就是一个json字符串,它时将用户信息保存到一个json字符串中
 *      然后通过编码得到一个JWT的token,这个token、是带有签名信息的可以防止
 *      被篡改。用于多个服务之间安全传输信息用。
 *  优势: 相比较传统的session会话机制
 *       1.数据量更小,传输速度更快
 *       2.不再依赖服务端的会话保存机制,可以更好的和多类型客户端交互
 *       3.它支持设置有效时间
 *
 *  组成: JWT由于三个部分组成 标头.有效载荷.签名 在传输的过程中
 *       会将JWT的三个部分分别进行Base64编码后再进行最后的拼接
 *
 *       标头:描述的是JWT的元数据
 *       {
 *           alg:"签名算法"---》HMAC哈希验证码(对称)
 *           typ:“令牌类型”---》JWT
 *       }
 *       有效载荷: 是JWT的主题内容部分也就是一个json包含了所有需要传输的数据
 *       {
 *           iss:发行人
 *           exp:到期时间
 *           sub:主题
 *           add:用户
 *           nbf:在此之前不可用
 *           iat:发布时间
 *           jti:ID用于JWT标识
 *       }
 *       签名:是相应签名算法对上诉两个部分的数据签名,需要上述两个部分编码之后的值
 *           通过算法生成指定字符串
 *
 *
 */

public class JWTUtil {

    //签名秘钥
    private static final String SECRET="!&*bhjBHJ3";

    /**
     * 生成token
     * @param payload
     * @return
     */
    public static String getToken(Map<String,String> payload){
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DATE,7);

        JWTCreator.Builder builder= JWT.create();

        payload.forEach((k,v)->builder.withClaim(k,v));

        String token=builder.withExpiresAt(calendar.getTime()).sign(Algorithm.HMAC256(SECRET));
        return token;
    }

    /**
     * 解码token
     * @param token
     * @return
     * @throws Exception
     */
    public static DecodedJWT decoded(String token) throws Exception{
        JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT decodedJWT=jwtVerifier.verify(token);
        return decodedJWT;
    }




}
