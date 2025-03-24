import React, { useEffect, useState } from "react";
import axios from "axios";
import { useParams, useNavigate } from "react-router-dom";

function EmpDetail() {

    const {id} = useParams();
    const [empObject, setEmpObject] = useState({});

    const navigate = useNavigate();
    const callList = () =>{ navigate('/emplist') };
    const callUpdate = () =>{ navigate(`/empupdate/${id}`) };

    useEffect(
        () => {
            axios.get(`http://localhost:8080/emp/detail/${id}`)
                    .then( response =>setEmpObject(response.data) )
                    .catch( error => console.log(error) );
        }, {}
    );

    const removeEmpRow = () => {
        const delYN = window.confirm(`정말 삭제 할까요?${id}`);
        if (delYN) {
          axios.delete( `http://localhost:8080/emp/delete/${id}` )
                .then( response => {
                  alert('삭제 성공!');
                  navigate('/emplist');
                })
                .catch( error => console.log(error) );
        }
    };
 
    return(
        <div>
            <h1>사원 상세</h1>
            <table class='table table-hover'>
            <tbody>
                    <tr>
                        <th>no</th> <td>{empObject.id}</td>
                        <th>부서번호</th> <td>{empObject.deptno}</td>
                        <th>관리자번호</th> <td>{empObject.mgr}</td>
                    </tr>
                    <tr>
                        <th>사원번호</th> <td>{empObject.empno}</td>
                        <th>사원명</th> <td>{empObject.ename}</td>
                        <th>직업</th> <td>{empObject.job}</td>
                    </tr>
                    <tr>
                        <th>입사일</th> <td>{empObject.hiredate}</td>
                        <th>급여</th> <td>{empObject.sal}</td>
                        <th>수당</th> <td>{empObject.comm}</td>
                    </tr>
                </tbody>
            </table>
            <div class="text-right mb-1">
                <button class="btn btn-info mr-1" onClick={callUpdate}> 수정 하기 </button>
                <button class="btn btn-warning" onClick={callList}> 목록 가기 </button>
            </div>
        </div>
    );

}

export default EmpDetail;
