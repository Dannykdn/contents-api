package com.mylo.spring.controller.sample;

import com.mylo.domain.sample.model.Sample;
import com.mylo.spring.service.sample.SampleBO;
import com.mylo.util.aws.DefaultMyloFileUtils;
import com.mylo.util.aws.MyloFileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

import static com.mylo.domain.type.CvMetaType.CONTENTS;

//ToDo 해당 컨트롤러는 요청을 처리하는 동시에 Swagger API 문서를 작성할 수 있는 기반임.
@Api(tags = "샘플-API")
@RestController
@RequestMapping("/v1/api/sample") //ToDo 항상 컨트롤러 작성시 /vi/api path 는 필수!! 우리 mylo 규칙
@Slf4j
public class SampleController {
    @Autowired SampleBO sampleBO; //해당 BO 명칭은 항상 붙여줘야함. 소문자가 아닌 대문자로 처리하기 바람.
    //ToDo Aws 연동을 위한 파일 Utils 파일 업로드 / 파일 삭제 / CloudFront 처리를 담당.
    private MyloFileUtils myloFileUtils = DefaultMyloFileUtils.getInstance();


    @ApiOperation(value = "s3 upload")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void s3FileUpload(@RequestParam MultipartFile file){
        // s3 파일 업로드
        myloFileUtils.uploadMyloFile(CONTENTS, file, false);
        // 해당 파일이 등록된 url
        String url = myloFileUtils.getMyloFileURL(CONTENTS, file);
        log.info("url : {}", url);
        // 해당 파일 삭제
        myloFileUtils.removeMyloFile(CONTENTS, file);
    }
    @ApiOperation(value = "샘플 리스트 조회 API")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Map<String, Object> getSampleList(@RequestParam(required = false) Integer idx,
                                             @RequestParam(required = false) String keyword,
                                             @RequestParam(defaultValue = "1") int pageNum,
                                             @RequestParam(defaultValue = "30") int pageSize){


        return sampleBO.getSampleList(idx, keyword, pageNum, pageSize);
    }
    @ApiOperation(value = "샘플 리스트 조회 API")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public int insertSample(@RequestBody Sample sample){
        return sampleBO.insertSample(sample);
    }
}
