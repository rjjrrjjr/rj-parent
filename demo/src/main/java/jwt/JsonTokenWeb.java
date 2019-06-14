package jwt;

import java.security.Key;
import java.util.Map;

import org.dozer.DozerBeanMapper;

import domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

/**
 * Created by 10064028 on 2018/1/31.
 */
public class JsonTokenWeb {

    public static void main(String[] args) {

        Key key = MacProvider.generateKey();
        DozerBeanMapper mapper = new DozerBeanMapper();

        /* 生成token */
        User user = new User();
        user.setName("rj");
        user.setAge(18);
        Map<String, Object> params = mapper.map(user, Map.class);
        params.put("platform", "local");
        String token = Jwts.builder().setClaims(params).setSubject("rj").signWith(SignatureAlgorithm.HS512, key).compact();
        System.out.println(token);

        /* 解析token */
        Claims body = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        String subject = body.getSubject();
        User userNew = mapper.map(body, User.class);
        String platform = (String) body.get("platform");
        System.out.println("subject: " + subject);
        System.out.println("=================================");
        System.out.println(userNew.getName() + userNew.getAge());
        System.out.println("=================================");
        System.out.println(platform);
    }
}
