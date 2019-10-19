const valid = document.getElementById("validation");
const lastName = document.getElementById("last_name");
const name = document.getElementById("name");
const password = document.getElementById("password");
const age = document.getElementById("age");
let sex = document.getElementsByName("sex");
const course = document.getElementById('course');
const teacher = document.getElementById("teacher");
const grade = document.getElementById("grade");
const otherCourse = document.getElementById('other_course');
const tv = document.getElementById('tv');
const radio = document.getElementById('radio');
const inet = document.getElementById('inet');
const metro = document.getElementById('metro');
const friends = document.getElementById('friends');
const other = document.getElementById('other');
const otherText = document.getElementById('other_text');
const buttonTrueAnswer = document.getElementById('true_answer');
const buttonFalseAnswer = document.getElementById('false_answer');

function validation() {
    if (isEmpty(lastName.value)) {
        alert("«Фамилия» не может быть пустой");
        return;
    }
    if (isEmpty(name.value)) {
        alert("«Имя» не может быть пустым");
        return;
    }
    if (isEmpty(password.value)) {
        alert("«Секретная фраза» не может быть пустой.");
        return;
    }
    if (!/^[1-9]{1}[0-9]*$/.test(age.value) && !isEmpty(age.value)) {
        alert("«Возраст» измеряется только цифрами.");
        return;
    }
    if (!sex[0].checked && !sex[1].checked) {
        alert("Выберите пол");
        return;
    }
    if (isEmpty(course.value)) {
        alert("Выберите Курс, который Вы проходили.");
        return;
    }
    if (isEmpty(teacher.value)) {
        alert("Укажите преподавателя, который вел курс.");
        return;
    }
    if (isEmpty(grade.value)) {
        alert("Укажите, как Вы оценили курс.");
        return;
    }
    if (!(tv.checked || radio.checked || inet.checked ||
        metro.checked || friends.checked || other.checked)) {
        alert("Укажите, как Вы узнали о нас.");
        return;
    }
    if (isEmpty(otherText.value) && other.checked) {
        alert("Отвергаешь – предлагай!");
        return;
    }
    return true;
}


lastName.onblur = function () {
    if (isEmpty(this.value)) {
        setInvalid(this);
    }
};

lastName.onfocus = function () {
    setValid(this);
};

name.onblur = function () {
    if (isEmpty(this.value)) {
        setInvalid(this);
    }
};

name.onfocus = function () {
    setValid(this);
};

password.onblur = function () {
    if (isEmpty(this.value)) {
        setInvalid(this);
    }
};

password.onfocus = function () {
    setValid(this);
};

function isEmpty(value) {
    return value.trim() === '';
}

function setInvalid(object) {
    object.classList.add('invalid');
}

function setValid(object) {
    if (object.classList.contains('invalid')) {
        object.classList.remove('invalid');
    }
}

function enableOtherField() {
    if (other.checked) {
        otherText.disabled = false;
    } else {
        otherText.disabled = true;
        otherText.value = '';
    }
}

function disableSelectedCourseInOtherCourses() {
    for (let elem of otherCourse.children) {
        elem.disabled = false;
        if (course.value === elem.value) {
            elem.disabled = true;
            elem.selected = false;
        }
    }
}

buttonTrueAnswer.addEventListener("click", function () {
    if (!valid.checked) {
        if (!validation()) {
            return;
        }
    }
    let answerOuter = document.createElement('div');
    answerOuter.className = "answer_outer";

    let ok = document.createElement("button");
    ok.innerHTML = "Ok";

    let trueForm = document.createElement("div");
    trueForm.className = "true_form";
    trueForm.className = "answer";
    trueForm.innerHTML = "<p>Браво, честный человек!</p><p>Смело отправляйся смотреть результат!</p>";

    trueForm.append(ok);
    answerOuter.append(trueForm);
    document.body.append(answerOuter);
    ok.addEventListener("click", function () {
        answerOuter.remove();
        document.getElementById("my_form").submit();
    });
});

buttonFalseAnswer.addEventListener("click", function () {
    if (!valid.checked) {
        if (!validation()) {
            return;
        }
    }
    let answerOuter = document.createElement('div');
    answerOuter.className = "answer_outer";

    let ok = document.createElement("button");
    ok.innerHTML = "Ok";
    let cancel = document.createElement("button");
    cancel.innerHTML = "Cancel";

    let falseForm = document.createElement("div");
    falseForm.className = "true_form";
    falseForm.className = "answer";
    falseForm.innerHTML = "<p>Вообще-то врать не хорошо,</p>" +
        "<p>даже если не видят...</p>" +
        "<p>Точно отправляем?</p>";

    falseForm.append(ok);
    falseForm.append(cancel);
    answerOuter.append(falseForm);
    document.body.append(answerOuter);

    ok.addEventListener("click", function () {
        answerOuter.remove();
        document.getElementById("my_form").submit();
    });
    cancel.addEventListener("click", function () {
        answerOuter.remove();
    });
});
