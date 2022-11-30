# CONTENTS 타입에 따른 메타 처리

## ContentsController

### ANNOTATION
- **@ApiOperation**
  - method의 설명을 작성할 수 있음.
- **@RequestMapping**
  - value와 method로 url에 해당하는 method를 정의해 준다.
- **@RequestParam**
  - 객체 생성 불가능
  - 변수에 1:1 바인딩 가능
- **@RequestBody**
  - 객체 생성 가능
  - 변수 1:1 바인딩 불가능


### FILE
- **selectContents()**
    - 기능 : 파일 상세조회
    - 필수 : (Integer) idx
- **selectContentsList()**
    - 기능 : 파일 리스트 조회
    - 선택 : (Integer) idx
- **uploadContents()**
    - 기능 : 파일 업로드
    - 필수 : (formData) file

### META
- selectContentsMeta()
    - 기능 : 메타데이터 상세조회
    - 필수 : (Integer) idx
- selectContentsMetaList()
    - 기능 : 메타데이터 리스트 조회
    - 선택 : (Integer) idx / (String) item,value
- insertContentsMeta()
    - 기능 : 메타데이터 삽입
    - 필수 : (ContentsMeta) meta
- updateContentsMeta()
    - 기능 : 메타데이터 수정
    - 필수 : (ContentsMeta) meta
- deleteContentsMeta()
    - 기능 : 메타데이터 삭제
    - 필수 : (Integer) idx



