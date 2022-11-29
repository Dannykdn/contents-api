package com.mylo.spring.controller.contents;

import com.mylo.domain.contents.model.ContentsMeta;
import com.mylo.spring.service.contents.ContentsBO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Api(tags = "Contents-API")
@RestController
@RequestMapping(value = "/v1/api/contents")
@Slf4j
public class ContentsController {

    @Autowired ContentsBO contentsBO;


    @ApiOperation(value = "Contents 파일 업로드 API",
            notes = "<fieldset>" +
                    "   <legend><b>Contents 파일 업로드</b></legend>" +
                    "   <ul>" +
                    "     <li>Contents 파일을 업로드 하는 API</li>" +
                    "   </ul>" +
                    "</fieldset><br/>" +
                    // 주의사항
                    "<fieldset>" +
                    "   <legend><b>주의사항은 아래와 같습니다</b></legend>" +
                    "   <ul>" +
                    "     <li>이미 존재하는 이름의 파일을 업로드 할 경우 덮어쓰기됨.</li>" +
                    "   </ul>" +
                    "</fieldset><br/>" +
                    // request exam
                    "<fieldset>" +
                    "   <legend><b>리퀘스트 데이터는 다음과 같습니다</b></legend>" +
                    "   <ul>" +
                    "     <li>필수입력 값<br/> - file</li>" +
                    "   </ul>" +
                    "   <pre>{\n" +
                    "     \"file\": formData,\n" +
                    "}</pre>" +
                    "</fieldset><br/>" +
                    // response exam
                    "<fieldset>" +
                    "   <legend><b>리스폰스 데이터는 다음과 같습니다</b></legend>" +
                    "   <pre>{\n" +
                    "   \"code\": int,\n" +
                    "   \"message\": String,\n" +
                    "   \"resultData\": boolean\n" +
                    "}</pre>" +
                    "</fieldset><br/>" +
                    // error code exam
                    "<fieldset>" +
                    "   <legend><b>나타날 수 있는 실패 \"code\" 및 원인은 다음과 같습니다</b></legend>" +
                    "   <ul>" +
                    "     <li>파일 업로드 실패</li>" +
                    "     <li>652 [FAIL]: 파일 업로드 중 오류가 발생하였습니다.</li>" +
                    "   </ul>" +
                    "   <ul>" +
                    "     <li>DB 저장 실패</li>" +
                    "     <li>201 [FAIL]: DB에 insert 중 오류가 발생하였습니다.</li>" +
                    "   </ul>" +
                    "</fieldset>"
    )
    @RequestMapping(value = "/file/upload", method = RequestMethod.POST)
    public boolean uploadContents(@RequestParam MultipartFile file){

        return contentsBO.uploadContents(file);
    }

    @ApiOperation(value = "Contents 파일 상세조회 API",
            notes = "<fieldset>" +
                    "   <legend><b>Contents 파일 상세조회</b></legend>" +
                    "   <ul>" +
                    "     <li>idx를 통한 파일의 url 조회 API</li>" +
                    "   </ul>" +
                    "</fieldset><br/>" +
                    // 주의사항
                    "<fieldset>" +
                    "   <legend><b>주의사항은 아래와 같습니다</b></legend>" +
                    "   <ul>" +
                    "     <li>idx는 필수입력 값입니다.</li>" +
                    "   </ul>" +
                    "</fieldset><br/>" +
                    // request exam
                    "<fieldset>" +
                    "   <legend><b>리퀘스트 데이터는 다음과 같습니다</b></legend>" +
                    "   <ul>" +
                    "     <li>필수입력 값<br/>- idx</li>" +
                    "   </ul>" +
                    "   <pre>{\n" +
                    "     \"idx\":Integer,\n" +
                    "}</pre>" +
                    "</fieldset><br/>" +
                    // response exam
                    "<fieldset>" +
                    "   <legend><b>리스폰스 데이터는 다음과 같습니다</b></legend>" +
                    "   <pre>{\n" +
                    "   \"code\": int,\n" +
                    "   \"message\": String,\n" +
                    "   \"resultData\": {\n" +
                    "     \"idx\": int,\n" +
                    "     \"url\": String\n" +
                    "   }\n" +
                    "}</pre>" +
                    "</fieldset><br/>" +
                    // error code exam
                    "<fieldset>" +
                    "   <legend><b>나타날 수 있는 실패 \"code\" 및 원인은 다음과 같습니다</b></legend>" +
                    "   <ul>" +
                    "     <li>idx가 0일 때</li>" +
                    "     <li>604 [FAIL]: Invalid idx !!</li>" +
                    "   </ul>" +
                    "</fieldset>"
    )
    @RequestMapping(value = "/file/select", method = RequestMethod.GET)
    public Map<String, Object> getContents(@RequestParam Integer idx){

        return contentsBO.selectContents(idx);
    }

    @ApiOperation(value = "Contents 파일 리스트 조회 API",
            notes = "<fieldset>" +
                    "   <legend><b>Contents 파일 리스트 조회</b></legend>" +
                    "   <ul>" +
                    "     <li>Contents 파일의 전체 또는 idx를 통한 부분 조회 API</li>" +
                    "   </ul>" +
                    "</fieldset><br/>" +
                    // request exam
                    "<fieldset>" +
                    "   <legend><b>리퀘스트 데이터는 다음과 같습니다</b></legend>" +
                    "   <ul>" +
                    "     <li>선택입력 값<br/> - idx</li>" +
                    "   </ul>" +
                    "   <pre>{\n" +
                    "     \"idx\":Integer,\n" +
                    "}</pre>" +
                    "</fieldset><br/>" +
                    // response exam
                    "<fieldset>" +
                    "   <legend><b>리스폰스 데이터는 다음과 같습니다</b></legend>" +
                    "   <pre>{\n" +
                    "   \"code\": int,\n" +
                    "   \"message\": String,\n" +
                    "   \"resultData\": {\n" +
                    "     \"itemList\": [\n" +
                    "       {\n" +
                    "         \"idx\": int,\n" +
                    "         \"url\": String\n" +
                    "       },\n" +
                    "       ...\n" +
                    "     ]\n" +
                    "   }\n" +
                    "}</pre>" +
                    "</fieldset>"
    )
    @RequestMapping(value = "/file/select-list", method = RequestMethod.GET)
    public Map<String, Object> getContentsList(@RequestParam(required = false) Integer idx){

        return contentsBO.selectContentsList(idx);
    }

    @ApiOperation(value = "Contents 메타데이터 삽입 API",
            notes = "<fieldset>" +
                    "   <legend><b>Contents 메타데이터 삽입</b></legend>" +
                    "   <ul>" +
                    "     <li>contentIdx를 통한 메타데이터 삽입 API</li>" +
                    "   </ul>" +
                    "</fieldset><br/>" +
                    // 주의사항
                    "<fieldset>" +
                    "   <legend><b>주의사항은 아래와 같습니다</b></legend>" +
                    "   <ul>" +
                    "     <li>contentsIdx에 해당하는 file이 없을 시 삽입이 불가합니다.</li>" +
                    "   </ul>" +
                    "</fieldset><br/>" +
                    // request exam
                    "<fieldset>" +
                    "   <legend><b>리퀘스트 데이터는 다음과 같습니다</b></legend>" +
                    "   <ul>" +
                    "     <li>필수입력 값<br/> - contentsIdx, metaJson, typeIdx</li>" +
                    "   </ul>" +
                    "   <pre>{\n" +
                    "     \"contentsIdx\":Integer,\n" +
                    "     \"metaJson\":Object,\n" +
                    "     \"typeIdx\":ENUM(VIDEO, CONTENTS, TEXT, VOICE, IMAGE)\n" +
                    "}</pre>" +
                    "</fieldset><br/>" +
                    // response exam
                    "<fieldset>" +
                    "   <legend><b>리스폰스 데이터는 다음과 같습니다</b></legend>" +
                    "   <pre>{\n" +
                    "   \"code\": int,\n" +
                    "   \"message\": String,\n" +
                    "   \"resultData\": boolean\n" +
                    "}</pre>" +
                    "</fieldset><br/>" +
                    // error code exam
                    "<fieldset>" +
                    "   <legend><b>나타날 수 있는 실패 \"code\" 및 원인은 다음과 같습니다</b></legend>" +
                    "   <ul>" +
                    "     <li>contentsIdx에 대한 메타데이터가 이미 존재함</li>" +
                    "     <li>651 [FAIL]: contentsIdx에 대한 메타데이터가 이미 존재합니다.</li>" +
                    "   </ul>" +
                    "   <ul>" +
                    "     <li>contentsIdx에 대한 파일이 없음</li>" +
                    "     <li>650 [FAIL]: contentsIdx에 대한 파일이 없습니다.</li>" +
                    "   </ul>" +
                    "   <ul>" +
                    "     <li>DB insert 실패</li>" +
                    "     <li>201 [FAIL]: DB에 insert 중 오류가 발생하였습니다.</li>" +
                    "   </ul>" +
                    "   <ul>" +
                    "     <li>contentsIdx가 0일 때</li>" +
                    "     <li>604 [FAIL]: Invalid idx !!</li>" +
                    "   </ul>" +
                    "   <ul>" +
                    "     <li>metaJson이 빈값일 때</li>" +
                    "     <li>604 [FAIL]: There is anything in metaJson !!</li>" +
                    "   </ul>" +
                    "   <ul>" +
                    "     <li>Enum의 값이 잘못 되었을 때</li>" +
                    "     <li>604 [FAIL]: Enum의 값이 잘못 되었습니다.</li>" +
                    "   </ul>" +
                    "</fieldset>"
    )
    @RequestMapping(value = "/meta/insert", method = RequestMethod.POST)
    public boolean insertContentsMeta(@RequestBody ContentsMeta meta){

        return contentsBO.insertContentsMeta(meta);
    }

    @ApiOperation(value = "Contents 메타데이터 상세조회 API",
            notes = "<fieldset>" +
                    "   <legend><b>Contents 메타데이터 상세조회</b></legend>" +
                    "   <ul>" +
                    "     <li>contentsIdx를 통한 메타데이터 상세조회</li>" +
                    "   </ul>" +
                    "</fieldset><br/>" +
                    // request exam
                    "<fieldset>" +
                    "   <legend><b>리퀘스트 데이터는 다음과 같습니다</b></legend>" +
                    "   <ul>" +
                    "     <li>필수입력 값<br/> - contentsIdx</li>" +
                    "   </ul>" +
                    "   <pre>{\n" +
                    "     \"contentsIdx\":Integer\n" +
                    "}</pre>" +
                    "</fieldset><br/>" +
                    // response exam
                    "<fieldset>" +
                    "   <legend><b>리스폰스 데이터는 다음과 같습니다</b></legend>" +
                    "   <pre>{\n" +
                    "   \"code\": int,\n" +
                    "   \"message\": String,\n" +
                    "   \"resultData\": {\n" +
                    "     \"idx\": int,\n" +
                    "     \"typeIdx\": int,\n" +
                    "     \"contentsIdx\": int,\n" +
                    "     \"metaJson\": Map<String, Object>,\n" +
                    "     \"regDate\": Timestamp,\n" +
                    "     \"updateDate\": Timestamp\n" +
                    "   }\n" +
                    "}</pre>" +
                    "</fieldset><br/>" +
                    // error code exam
                    "<fieldset>" +
                    "   <legend><b>나타날 수 있는 실패 \"code\" 및 원인은 다음과 같습니다</b></legend>" +
                    "   <ul>" +
                    "     <li>contentsIdx가 0일 때</li>" +
                    "     <li>604 [FAIL]: Invalid idx !!</li>" +
                    "   </ul>" +
                    "</fieldset>"
    )
    @RequestMapping(value = "/meta/select", method = RequestMethod.GET)
    public Map<String, Object> getContentsMeta(@RequestParam Integer contentsIdx){

        return contentsBO.selectContentsMeta(contentsIdx);
    }

    @ApiOperation(value = "Contents 메타데이터 리스트 조회 API",
            notes = "<fieldset>" +
                    "   <legend><b>Contents 메타데이터 리스트 조회</b></legend>" +
                    "   <ul>" +
                    "     <li>Contents 메타데이터의 전체 또는 contentsIdx를 통한 상세조회 및 메타데이터의 항목/값 검색을 통한 상세조회 API/li>" +
                    "   </ul>" +
                    "</fieldset><br/>" +
                    // request exam
                    "<fieldset>" +
                    "   <legend><b>리퀘스트 데이터는 다음과 같습니다</b></legend>" +
                    "   <ul>" +
                    "     <li>선택입력 값<br/> - contentsIdx, item/value</li>" +
                    "   </ul>" +
                    "   <pre>{\n" +
                    "     \"contentsIdx\": int,\n" +
                    "     \"item\": String,\n" +
                    "     \"value\": String\n" +
                    "}</pre>" +
                    "</fieldset><br/>" +
                    // response exam
                    "<fieldset>" +
                    "   <legend><b>리스폰스 데이터는 다음과 같습니다</b></legend>" +
                    "   <pre>{\n" +
                    "   \"code\": int,\n" +
                    "   \"message\": String,\n" +
                    "   \"resultData\": {\n" +
                    "       \"itemList\": [\n" +
                    "         {\n" +
                    "           \"idx\": int,\n" +
                    "           \"typeIdx\": int,\n" +
                    "           \"contentsIdx\": int,\n" +
                    "           \"metaJson\": Map<String, Object>,\n" +
                    "           \"regDate\": Timestamp,\n" +
                    "           \"updateDate\": Timestamp\n" +
                    "         },\n" +
                    "         ...\n" +
                    "       ]\n" +
                    "   }\n" +
                    "}</pre>" +
                    "</fieldset>"
    )
    @RequestMapping(value = "/meta/select-list", method = RequestMethod.GET)
    public Map<String, Object> getContentsMetaList(@RequestParam(required = false) Integer contentsIdx,
                                                   @RequestParam(required = false) String item,
                                                   @RequestParam(required = false) String value){

        return contentsBO.selectContentsMetaList(contentsIdx, item, value);
    }

    @ApiOperation(value = "Contents 메타데이터 수정 API",
            notes = "<fieldset>" +
                    "   <legend><b>Contents 메타데이터 수정</b></legend>" +
                    "   <ul>" +
                    "     <li>contentsIdx를 통한 메타데이터 수정</li>" +
                    "   </ul>" +
                    "</fieldset><br/>" +
                    // request exam
                    "<fieldset>" +
                    "   <legend><b>리퀘스트 데이터는 다음과 같습니다</b></legend>" +
                    "   <ul>" +
                    "     <li>필수입력 값<br/> - contentsIdx, metaJson, typeIdx</li>" +
                    "   </ul>" +
                    "   <pre>{\n" +
                    "     \"contentsIdx\":Integer,\n" +
                    "     \"metaJson\":Object,\n" +
                    "     \"typeIdx\":ENUM(VIDEO, CONTENTS, TEXT, VOICE, IMAGE)\n" +
                    "}</pre>" +
                    "</fieldset><br/>" +
                    // response exam
                    "<fieldset>" +
                    "   <legend><b>리스폰스 데이터는 다음과 같습니다</b></legend>" +
                    "   <pre>{\n" +
                    "   \"code\": int,\n" +
                    "   \"message\": String,\n" +
                    "   \"resultData\": boolean\n" +
                    "}</pre>" +
                    "</fieldset><br/>" +
                    // error code exam
                    "<fieldset>" +
                    "   <legend><b>나타날 수 있는 실패 \"code\" 및 원인은 다음과 같습니다</b></legend>" +
                    "   <ul>" +
                    "     <li>contentsIdx에 대한 메타데이터가 없습니다.</li>" +
                    "     <li>650 [FAIL]: contentsIdx에 대한 메타데이터가 없습니다.</li>" +
                    "   </ul>" +
                    "   <ul>" +
                    "     <li>DB update 실패</li>" +
                    "     <li>203 [FAIL]: DB에 update 중 오류가 발생하였습니다.</li>" +
                    "   </ul>" +
                    "   <ul>" +
                    "     <li>contentsIdx가 0일 때</li>" +
                    "     <li>604 [FAIL]: Invalid idx !!</li>" +
                    "   </ul>" +
                    "   <ul>" +
                    "     <li>metaJson이 빈값일 때</li>" +
                    "     <li>604 [FAIL]: There is anything in metaJson !!</li>" +
                    "   </ul>" +
                    "</fieldset>"
    )
    @RequestMapping(value = "/meta/update", method = RequestMethod.POST)
    public boolean updateContentsMeta(@RequestBody ContentsMeta meta){

        return contentsBO.updateContentsMeta(meta);
    }

    @ApiOperation(value = "Contents 메타데이터 삭제 API",
            notes = "<fieldset>" +
                    "   <legend><b>Contents 메타데이터 삭제</b></legend>" +
                    "   <ul>" +
                    "     <li>contentsIdx를 통한 메타데이터 삭제</li>" +
                    "   </ul>" +
                    "</fieldset><br/>" +
                    // request exam
                    "<fieldset>" +
                    "   <legend><b>리퀘스트 데이터는 다음과 같습니다</b></legend>" +
                    "   <ul>" +
                    "     <li>필수입력 값<br/> - contentsIdx</li>" +
                    "   </ul>" +
                    "   <pre>{\n" +
                    "     \"contentsIdx\":Integer\n" +
                    "}</pre>" +
                    "</fieldset><br/>" +
                    // response exam
                    "<fieldset>" +
                    "   <legend><b>리스폰스 데이터는 다음과 같습니다</b></legend>" +
                    "   <pre>{\n" +
                    "   \"code\": int,\n" +
                    "   \"message\": String,\n" +
                    "   \"resultData\": boolean\n" +
                    "}</pre>" +
                    "</fieldset><br/>" +
                    // error code exam
                    "<fieldset>" +
                    "   <legend><b>나타날 수 있는 실패 \"code\" 및 원인은 다음과 같습니다</b></legend>" +
                    "   <ul>" +
                    "     <li>contentsIdx에 대한 메타데이터가 없습니다.</li>" +
                    "     <li>650 [FAIL]: contentsIdx에 대한 메타데이터가 없습니다.</li>" +
                    "   </ul>" +
                    "   <ul>" +
                    "     <li>DB delete 실패</li>" +
                    "     <li>204 [FAIL]: DB에 delete 중 오류가 발생하였습니다.</li>" +
                    "   </ul>" +
                    "   <ul>" +
                    "     <li>contentsIdx가 0일 때</li>" +
                    "     <li>604 [FAIL]: Invalid idx !!</li>" +
                    "   </ul>" +
                    "</fieldset>"
    )
    @RequestMapping(value = "/meta/delete", method = RequestMethod.GET)
    public boolean deleteContentsMeta(@RequestParam(required = false) Integer contentsIdx){

        return contentsBO.deleteContentsMeta(contentsIdx);
    }
}
