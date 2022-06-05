"use strict";
const url = new URL("http://localhost:8081/api/faculty");

window.addEventListener('DOMContentLoaded', () => {


    fetch(url)
        .then(res => res.json())
        .then(data => {

            for (let faculty of data) {
                document.getElementById("facultyx").innerHTML += `
                <div class = 'numefac'>  <p id = '${faculty.name}'>${faculty.name}</p>
                <p id='${faculty.name}an1' class=' ancolorat'>An 1</p>
                <p id='${faculty.name}an2' class='ancolorat'>An 2 </p>
                <p id='${faculty.name}an3' class='ancolorat'> An 3 </p>
                 </div>
            `
            }

            for (let faculty of data) {

                const getRows = (data) => {
                    let fullStr = '';
                    for (let student of data) {
                        fullStr += `
                                <tr>
                                    <td>
                                        ${student.lastName}
                                    </td>
                                    <td>
                                        ${student.firstName}
                                    </td>
                                    <td>
                                        ${student.faculty}
                                    </td>
                                    <td>
                                        ${student.year}
                                    </td>
                                    <td>
                                        ${student.average / 100}
                                    </td>
                                    <td>
                                        ${student.studentDorm}
                                    </td>
                                </tr>

                            `
                    }
                    return fullStr;
                }


                for (let i = 1; i <= 3; i++) {

                    document.getElementById(`${faculty.name}an${i}`).addEventListener('click', () => {



                        document.getElementById("tablePart").innerHTML = '';
                        const url = new URL(`http://localhost:8081/api/ranking/${faculty.name}/${i}`);
                        // console.log(url);
                        fetch(url)
                            .then(res => {
                                return res.json();
                            })
                            .then(data => {
                                // console.log(data);
                                document.getElementById("tablePart").innerHTML += `
                                    
                                    <table>
                                    <thead>
                                        <tr>
                                            <td>Nume</td>
                                            <td>Prenume</td>
                                            <td>Facultate</td>
                                            <td>An</td>
                                            <td>Medie</td>
                                            <td>Camin</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        ${getRows(data)}
                                    </tbody >
                                </table >
    
                                    `;
                            });
                    })

                }


            }
        })

})







