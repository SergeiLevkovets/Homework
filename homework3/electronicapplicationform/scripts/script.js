
document.getElementById(last_name).onblur = function() {
    if (document.getElementById(last_name).value.test(' *')) { // не email
        document.getElementById(last_name).classList.add('invalid');
        document.getElementById(inner_result).innerHTML = 'Пожалуйста, введите правильный email.'
    }
};

document.getElementById(last_name).onfocus = function() {
    if (this.classList.contains('invalid')) {
        // удаляем индикатор ошибки, т.к. пользователь хочет ввести данные заново
        this.classList.remove('invalid');
        document.inner_result.innerHTML = "правильное имя";
    }
}