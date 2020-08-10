package com.kp.springweb.converter;

import com.kp.springweb.springmvc2.DemoOBJ;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class MyHttpMessageConvertor extends AbstractHttpMessageConverter<DemoOBJ> {

    public MyHttpMessageConvertor() {
        super(new MediaType("application", "x-kp", Charset.forName("UTF-8")));
    }

    @Override  //支持哪种类型的转换
    protected boolean supports(Class<?> aClass) {

        //   return DemoOBJ.class==aClass;  无法与子类匹配
        return DemoOBJ.class.isAssignableFrom(aClass);
    }

    @Override //从浏览器获得数据，转换成DemoOBJ对象
    protected DemoOBJ readInternal(Class aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        //获取请求内容
        InputStream body = httpInputMessage.getBody();
        String str = StreamUtils.copyToString(body, Charset.forName("UTF-8"));//id-name
        String[] strs = str.split("-");
        return new DemoOBJ(new Integer(strs[0]), strs[1]);
    }

    @Override //将DemoOBJ对象转换成自定义格式的内容输出
    protected void writeInternal(DemoOBJ o, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        String str = o.getAge() + "-" + o.getName();
        httpOutputMessage.getBody().write(str.getBytes(Charset.forName("UTF-8")));
    }
}
