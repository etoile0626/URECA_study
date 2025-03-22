//3. 외부 js 파일 연결

//var = 변수 선언
var functionVar = document.querySelector("#first"); //first라는 이름의 객체를 찾아와 반환
functionVar.onclick = function(){                //h1에서 클릭이 일어나면
functionVar.style.color="red";              //색을 빨강으로
}


function testFunction(){
    alert("testFunction 실행");
}

