package org.example.spring.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import org.example.spring.entity.User;
import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * spring 示例
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/11/30 16:40
 */
@RestController
@RequestMapping("/")
public class DemoController {
    /**
     * 接收header信息
     *
     * @return
     */
    @GetMapping("/headerAll")
    public ResponseEntity<String> listAllHeaders(@RequestHeader Map<String, String> headers) {

        headers.forEach((key, value) -> {
            System.out.println("Header " + key + " = " + value);
        });

        return new ResponseEntity<String>(
                String.format("Listed %d headers", headers.size()), HttpStatus.OK);
    }

    /**
     * 接收单个header信息
     *
     * @param language
     * @return
     */
    @GetMapping("/headerSingle")
    public ResponseEntity<String> greeting(@RequestHeader("User-Agent") String language) {
        return new ResponseEntity<String>(language, HttpStatus.OK);
    }

    /**
     * 接收query信息
     *
     * @param id
     * @return
     */
    @GetMapping("/query")
    public ResponseEntity<String> query(String id, String name) {
        return new ResponseEntity<String>(id + "_" + name, HttpStatus.OK);
    }

    /**
     * 接收form-data信息-第1种方式
     * curl --request POST \
     * --url 'http://localhost:10002/formData?id=googd&name=jjj' \
     * --header 'content-type: multipart/form-data' \
     * --form id=2323 \
     * --form name=jim222
     *
     * @param id
     * @return
     */
    @PostMapping("/formData")
    public String formData(String id, String name) {
        Map<String, String> map = new HashMap<>();
        map.put(id, name);
        return JSONUtil.toJsonStr(map);
    }

    /**
     * 接收form-data信息-第2种方式
     *
     * @param user
     * @return
     */
    @PostMapping("/formData2")
    public String formData2(User user) {

        return JSONUtil.toJsonStr(user);
    }

    /**
     * 接收json
     *
     * @param user
     * @return
     */
    @PostMapping("/json")
    public String json(@RequestBody User user) {

        return JSONUtil.toJsonStr(user);
    }

    /**
     * 上传文件
     *
     * @param multipartfile
     * @return
     */
    @PostMapping("/upload")
    public String upload(MultipartFile multipartfile) {
        return multipartfile.getOriginalFilename();

    }

    /**
     * 上传多个文件
     *
     * @param multipartfile
     * @return
     */
    @PostMapping("/uploads")
    public String upload(MultipartFile[] multipartfile, User user) {
        List<String> propertyList = Arrays.stream(multipartfile)
                .map(obj -> obj.getOriginalFilename())
                .collect(Collectors.toList());
        return JSONUtil.toJsonStr(propertyList);

    }
}