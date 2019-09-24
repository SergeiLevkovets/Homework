let form;
let costCourse;
let countLessonsOrHours;
let countLessons;
let countHours;
let lessonHours;
let isCountLessons;

document.getElementById('calc').onclick = function () {
    form = document.forms.my_form;
    costCourse = form.courseCost.value;
    countLessonsOrHours = form.lessonsCount.value;
    lessonHours = form.hoursInLesson.value;
    isCountLessons = form.elements.count;
    
    if (!calculate()) {
        return;
    }
    let result = calculate();
    let text = `Стоимость каждого занятия: ${result[0].toFixed(2)} бел.руб<br>
               стоимость одного часа: ${result[1].toFixed(2)} бел.руб<br>
               стоимость одной минуты: ${result[2].toFixed(2)} бел.руб<br>
               стоимость одной секунды: ${result[3].toFixed(4)} бел.руб`;
    document.getElementById("inner_result").innerHTML += text;
    alert(document.getElementById("inner_result").textContent);
}

function calculate() {
    if (!costCourse || !countLessonsOrHours || !lessonHours) {
        alert('Заполните все поля');
        return;
    }
    let costHours;
    if (isCountLessons[0].checked) {
        countHours = countLessonsOrHours * lessonHours;
        costHours = costCourse / countLessonsOrHours / lessonHours;
        document.getElementById("inner_result").innerHTML = `Количество часов: ${countHours}\n<br>`;
        return [costHours * lessonHours, costHours, costHours / 60, costHours / 60 / 60]
    } else {
        countLessons = countLessonsOrHours / lessonHours;
        costHours = costCourse / countLessonsOrHours;
        document.getElementById("inner_result").innerHTML = `Количество занятий: ${countLessons}\n<br>`;
        return [costHours * lessonHours, costHours, costHours / 60, costHours / 60 / 60]
    }
}