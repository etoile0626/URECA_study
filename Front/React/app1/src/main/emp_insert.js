import React, {useEffect, useState} from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function EmpInsert() {

    const navigate = useNavigate();
    const callList = () => { navigate('/emplist'); };
  
    const [empInsRow, setEmpInsRow] = useState({
        empno:'',
        ename:'',
        job:'',
        mgr:'',
        hiredate:'',
        sal:'',
        comm:'',
        deptno:'',
      });

    const setData = (event) => {
        const { name, value } = event.target;
        setEmpInsRow((prevValues) => ({
            ...prevValues, [name]: value,
        }));
    };

    const saveEmpInsRow = () => {
        axios.post(`http://localhost:8080/emp/insert`, empInsRow)
              .then( response => {
                alert("입력 성공!");
                navigate('/emplist');
              })
              .catch( error => console.log(error) );
    };

    return(
        <div>
            <h1>사원 입력</h1>
            <table class='table table-hover'>
                <tbody>
                    <tr>
                        <th></th>
                        <td>
                        </td>
                        <th>부서번호</th>
                        <td>
                            <input type="text" name="deptno" value={empInsRow.deptno || ''} onChange={ setData } />
                        </td>
                        <th>관리자번호</th>
                        <td>
                            <input type="text" name="mgr" value={empInsRow.mgr || ''} onChange={ setData } />
                        </td>
                    </tr>
                    <tr>
                        <th>사원번호</th>
                        <td>
                            <input type="text" name="empno" value={empInsRow.empno || ''} onChange={ setData } />
                        </td>
                        <th>사원명</th>
                        <td>
                            <input type="text" name="ename" value={empInsRow.ename || ''} onChange={ setData } />
                        </td>
                        <th>직업</th>
                        <td>
                            <input type="text" name="job" value={empInsRow.job || ''} onChange={ setData } />
                        </td>
                    </tr>
                    <tr>
                        <th>입사일</th>
                        <td>
                            <input type="text" name="hiredate" value={empInsRow.hiredate || ''} onChange={ setData } />
                        </td>
                        <th>급여</th>
                        <td>
                            <input type="text" name="sal" value={empInsRow.sal || ''} onChange={ setData } />
                        </td>
                        <th>수당</th>
                        <td>
                            <input type="text" name="comm" value={empInsRow.comm || ''} onChange={ setData } />
                        </td>
                    </tr>
                </tbody>
            </table>
            <div class="text-right mb-1">
                <button class="btn btn-info mr-1" onClick={saveEmpInsRow}> 입력 하기 </button>
                <button class="btn btn-warning" onClick={callList}> 목록 가기 </button>
            </div>
        </div>
    );

}

export default EmpInsert;
