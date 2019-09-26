const chekOther = document.getElementById('other')
const other = document.getElementById('other_text');

function enableOther() {
    if (chekOther.checked){
        other.removeAttribute('disabled');
        other.setAttribute('required', '');
    }else {
        other.setAttribute('disabled', '');
        other.removeAttribute('required');
        other.value = '';
    }
}

document.getElementById('last_name').onblur = function() {
    if (!/^\S.*\S$/.test(document.getElementById('last_name').value)) { // не email
        document.getElementById('last_name').classList.add('invalid');
        alert('Пожалуйста, введите правильный имя.');
    }
};

document.getElementById('last_name').onfocus = function() {
    if (this.classList.contains('invalid')) {
        // удаляем индикатор ошибки, т.к. пользователь хочет ввести данные заново
        this.classList.remove('invalid');
    }
}

