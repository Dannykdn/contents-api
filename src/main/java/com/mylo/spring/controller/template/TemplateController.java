package com.mylo.spring.controller.template;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "템플릿-API")
@RestController
@RequestMapping(value = "/v1/api/template")
@Slf4j
public class TemplateController {


  @ApiOperation(value = "EXAM method template",
                notes = "<fieldset>" +
                        "   <legend><b>API에 대한 간단한 설명을 작성하는 부분입니다</b></legend>" +
                        "   <ul>" +
                        "     <li>부가 설명을 작성하는 부분입니다</li>" +
                        "   </ul>" +
                        "</fieldset><br/>" +
                        // 주의사항
                        "<fieldset>" +
                        "   <legend><b>주의사항은 아래와 같습니다</b></legend>" +
                        "   <ul>" +
                        "     <li>주의사항을 작성하는 부분입니다</li>" +
                        "   </ul>" +
                        "</fieldset><br/>" +
                        // request exam
                        "<fieldset>" +
                        "   <legend><b>리퀘스트 데이터는 다음과 같습니다</b></legend>" +
                        "   <ul>" +
                        "     <li>필수입력 값<br/> - exam1, exam2, exam3, exam4</li>" +
                        "   </ul>" +
                        "   <pre>{\n" +
                        "     \"Key\":Type,\n" +
                        "     \"exam1\":String,\n" +
                        "     \"exam2\":int\n" +
                        "}</pre>" +
                        "</fieldset><br/>" +
                        // response exam
                        "<fieldset>" +
                        "   <legend><b>리스폰스 데이터는 다음과 같습니다</b></legend>" +
                        "   <pre>{\n" +
                        "   \"code\": int,\n" +
                        "   \"message\": String,\n" +
                        "   \"resultData\": {\n" +
                        "     \"Key\": Type,\n" +
                        "     \"exam1\": String(\"예시1\", \"예시2\"),\n" +
                        "     \"exam2\": int\n" +
                        "   }\n" +
                        "}</pre>" +
                        "</fieldset><br/>" +
                        // error code exam
                        "<fieldset>" +
                        "   <legend><b>나타날 수 있는 실패 \"code\" 및 원인은 다음과 같습니다</b></legend>" +
                        "   <ul>" +
                        "     <li>에러 코드에 대한 설명을 작성하는 부분입니다</li>" +
                        "     <li>101 [FAIL]: 토큰값이 없거나, 정상적인 토큰이 아님 (토큰값을 잘못 입력하거나, 토큰 기간 만료, 비정상적인 접근 등)</li>" +
                        "   </ul>" +
                        "</fieldset>"
  )
  @RequestMapping(value = "/exam", method = RequestMethod.GET)
  public String examTemplate() {
    return "";
  }

  @ApiOperation(value = "EXAM method template (copy)",
                notes = "<fieldset>" +
                        "   <legend><b></b></legend>" +
                        "   <ul>" +
                        "     <li></li>" +
                        "   </ul>" +
                        "</fieldset><br/>" +
                        // 주의사항
                        "<fieldset>" +
                        "   <legend><b>주의사항은 아래와 같습니다</b></legend>" +
                        "   <ul>" +
                        "     <li></li>" +
                        "   </ul>" +
                        "</fieldset><br/>" +
                        // request exam
                        "<fieldset>" +
                        "   <legend><b>리퀘스트 데이터는 다음과 같습니다</b></legend>" +
                        "   <ul>" +
                        "     <li></li>" +
                        "   </ul>" +
                        "   <pre>{\n" +
                        "     \"Key\":Type\n" +
                        "}</pre>" +
                        "</fieldset><br/>" +
                        // response exam
                        "<fieldset>" +
                        "   <legend><b>리스폰스 데이터는 다음과 같습니다</b></legend>" +
                        "   <pre>{\n" +
                        "   \"code\": int,\n" +
                        "   \"message\": String,\n" +
                        "   \"resultData\": {\n" +
                        "     \"Key\": Type,\n" +
                        "   }\n" +
                        "}</pre>" +
                        "</fieldset><br/>" +
                        // error code exam
                        "<fieldset>" +
                        "   <legend><b>나타날 수 있는 실패 \"code\" 및 원인은 다음과 같습니다</b></legend>" +
                        "   <ul>" +
                        "     <li></li>" +
                        "   </ul>" +
                        "</fieldset>"
  )
  @RequestMapping(value = "/copy", method = RequestMethod.GET)
  public String copyTemplate() {
    return "";
  }
}