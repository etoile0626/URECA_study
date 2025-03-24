import React, {useEffect, useState} from "react";
import axios from "axios";
import { useParams, useNavigate } from "react-router-dom";

function EmpUpdate() {

    const navigate = useNavigate();
    const callList = () => { navigate('/emplist'); };

    const { id } = useParams();
    const [empObj, setEmpObj] = useState({});

    useEffect( () => {
        axios.get( `http://localhost:8080/emp/detail/${id}` )
              .then( response => setEmpObj(response.data)  )
              .catch( error => console.log(error) );
      }, [] );

    const setData = (event) => {
        const { name, value } = event.target;
        setEmpObj((prevValues) => ({
          ...prevValues, [name]: value,
        }));
    };

    const saveEmpInsRow = () => {
        axios.post(`http://localhost:8080/emp/update`, empObj)
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
                            <input type="text" name="deptno" value={empObj.deptno || ''} onChange={ setData } />
                        </td>
                        <th>관리자번호</th>
                        <td>
                            <input type="text" name="mgr" value={empObj.mgr || ''} onChange={ setData } />
                        </td>
                    </tr>
                    <tr>
                        <th>사원번호</th>
                        <td>
                            <input type="text" name="empno" value={empObj.empno || ''} onChange={ setData } />
                        </td>
                        <th>사원명</th>
                        <td>
                            <input type="text" name="ename" value={empObj.ename || ''} onChange={ setData } />
                        </td>
                        <th>직업</th>
                        <td>
                            <input type="text" name="job" value={empObj.job || ''} onChange={ setData } />
                        </td>
                    </tr>
                    <tr>
                        <th>입사일</th>
                        <td>
                            <input type="text" name="hiredate" value={empObj.hiredate || ''} onChange={ setData } />
                        </td>
                        <th>급여</th>
                        <td>
                            <input type="text" name="sal" value={empObj.sal || ''} onChange={ setData } />
                        </td>
                        <th>수당</th>
                        <td>
                            <input type="text" name="comm" value={empObj.comm || ''} onChange={ setData } />
                        </td>
                    </tr>
                </tbody>
            </table>
            <div class="text-right mb-1">
                <button class="btn btn-info mr-1" onClick={saveEmpInsRow}> 수정 하기 </button>
                <button class="btn btn-warning" onClick={callList}> 목록 가기 </button>
            </div>
        </div>
    );

}

export default EmpUpdate;
