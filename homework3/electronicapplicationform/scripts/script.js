const checkOther = document.getElementById('other');
const other = document.getElementById('other_text');
const course = document.getElementById('course');
const otherCourse = document.getElementById('other_course');

function enableOther() {
    if (checkOther.checked){
        other.disabled = false;
    }else {
        other.disabled = true
        other.value = '';
    }
}

function disableSelectCourse() {
    for (let elem of otherCourse.children){
        elem.disabled = false;
        if (course.value == elem.value){
            elem.disabled = true;
        }
    }

}

document.getElementById('last_name').onblur = function() {
    if (!/^\S.*\S$/.test(this.value)) { // не email
        this.classList.add('invalid');
        alert('Пожалуйста, введите правильное имя.');
    }
};

document.getElementById('last_name').onfocus = function() {
    if (this.classList.contains('invalid')) {
        // удаляем индикатор ошибки, т.к. пользователь хочет ввести данные заново
        this.classList.remove('invalid');
    }
}

