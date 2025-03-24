import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";

function EmpList() {

    const navigate = useNavigate();
    const callInsForm = () =>{ navigate('/empinsert') };

    const [empList, setEmpList] = useState([]);

    useEffect(
        () => {
            axios.get( 'http://localhost:8080/emp/list' )
                    .then( response => setEmpList(response.data) )
                    .catch( error => console.log(error) );
        }, []
    );

    return(
        <div>
            <h1>사원 목록</h1>
            <div class='text-right mb-2'>
                <button class='btn btn-info' onClick={callInsForm}>사원 입력으로 가기</button>
            </div>
            <table class='table table-hover'>
                <thead>
                    <tr>
                        <th>no.</th>     <th>사원번호</th>   <th>사원명</th>
                        <th>담당업무</th> <th>관리자번호</th> <th>입사일</th>
                        <th>급여</th>     <th>수당</th>      <th>부서번호</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        empList.map(
                            (emp) => (
                                <tr>
                                    <td>{emp.id}</td>       <td>{emp.empno}</td>
                                    <td>
                                        <Link to={`/empdetail/${emp.id}`}>{emp.ename}</Link>
                                    </td>
                                    <td>{emp.job}</td>      <td>{emp.mgr}</td>
                                    <td>{emp.hiredate}</td> <td>{emp.sal}</td>
                                    <td>{emp.comm}</td>     <td>{emp.deptno}</td>
                                </tr>
                            )
                        )
                    }
                </tbody>
            </table>
        </div>
    );

}

export default EmpList;
