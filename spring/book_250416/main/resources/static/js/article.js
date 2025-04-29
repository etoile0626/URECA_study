//삭제
const deleteButton = document.getElementById('delete-btn');

if(deleteButton) {
    deleteButton.addEventListener('click', event => {
        let id = document.getElementById('article-id').value;
        function success(){
            alert("삭제가 완료되었습니다.");
            location.replace("/articles");
        }
        function fail(){
            alert("삭제 실패.");
            location.replace("/articles");
        }

        httpRequest("DELETE", "/api/articles/" + id, null, success, fail);
    }); // deleteButton.addEventListener
} // if(deleteButton)

//수정
const modifyButton = document.getElementById('modify-btn');

if(modifyButton) { //클릭 이벤트가 감지 되면 수정 api 요청
    modifyButton.addEventListener('click', event => {
        let params = new URLSearchParams(location.search);
        let id = params.get('id');

        body: JSON.stringify({
            title: document.getElementById("title").value,
            content: document.getElementById("content").value,
        });

        function success(){
            alert("수정이 완료되었습니다.");
            location.replace("/articles");
        }
        function fail(){
            alert("수정 실패.");
            location.replace("/articles");
        }

        httpRequest("PUT", "/api/articles/" + id, body, success, fail);
    }); // modifyButton.addEventListener
} // if(modifyButton)

//생성
const createButton = document.getElementById('create-btn');

if(createButton) { //클릭이벤트 감지 시 등록 api 요청
    createButton.addEventListener('click', event => {
        body = JSON.stringify({
            title: document.getElementById("title").value,
            content: document.getElementById("content").value,
        });
        function success(){
            alert("등록 완료");
            location.replace("articles");
        }
        function fail(){
                    alert("등록 실패");
                    location.replace("articles");
        }
        httpRequest("POST", "/api/articles", body, success, fail);
    });
} // if(createButton)

function getCookie(key){
    var result = null;
    var cookie = document.cookie.split(";");
    cookie.some(function (item){
        item = item.replace(" ", "");
        var dic = item.split("=");
        if(key==dic[0]){
            result = dic[1];
            return true;
        }
    });
}
function httpRequest(method, url, body, success, fail){
    fetch(url, {
        method: method,
        headers: {
            Authorization: "Bearer " + localStorage.getItem("access_token"),
            "Content-Type", "application/json",
        },
        body: body
    })  //fetch
    .then((response) => {
        if(response.status === 200 || response.status === 201){
            return success();
        }

        const refresh_token = getCookie("refresh_token");
        if(response.status === 401 && refresh_token){
            fetch("/api/token", {
                method: "POST",
                headers: {
                    Authorization: "Bearer " + localStorage.getItem("access_token"),
                    "Content-Type", "application/json",
                },
                body: JSON.stringify({
                    refreshToken: getCookie("refresh_token"),
                }),
            })
            .then((res) => {
                if(res.ok) {
                    return res.json();
                }
            })
            .then((result) => {
                //재발급이 성공하면 새로운 엑세스 토큰 값으로 교체
                localStorage.setItem("access_token", result.accessToken);
                httpRequest(method, url, body, success, fail)
            })
            .catch((error) -> fail());
        } else{
            return fail();
        }
    });
}
