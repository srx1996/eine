package live.eine.fans;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("live.eine.fans.mapper")
public class FansApplication {

    public static void main(String[] args) {
        SpringApplication.run(FansApplication.class, args);
    }

}
