package com.trc.tlias;

import com.example.HeaderParser;
import com.example.TokenParser;
import com.trc.tlias.config.EnableHeaderAnnoation;
import com.trc.tlias.config.ModuleScannerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


//@ServletComponentScan
@SpringBootApplication
//@ComponentScan({"com.example","com.trc"})
//@Import({ModuleScannerConfig.class})
@EnableHeaderAnnoation
public class TliasApplication {

    public static void main(String[] args) {
        SpringApplication.run(TliasApplication.class, args);
    }

}
