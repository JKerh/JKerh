var person = {
    name: "张三",
    age: 15,
    hobby: ["看书", "篮球", "看电影"],
    teacher: {
        name: "李四",
        age: 30,
        course: ["语文", "数学"]
    }
};

var x=[1,2,3,4,5];
for (var j in x){
    // alert(x[j])
}//遍历数组

var str="hello";
for (var s in str){
    alert(str[s])
}//字符串也可以当作数组遍历

for (var key in person){
    if(key=="teacher"){
        for (var kk in person[key])
        alert(key+":"+kk+":"+person[key][kk])
    }else {
        alert(key+":"+person[key])
    }
}//遍历json对象




// alert(person["name"]);//获取person的key为name的值
// alert(person["hobby"][0]);//获取person的可以为hobby的value值，这个值是数组，取出第一个元素
// alert(person["teacher"]["name"]);//获取person值为teacher的value值，这个值数是json，取出这个json为name的值
// alert(person["teacher"]["course"][0])//获取person值为teacher的value值，这个值数是json，取出这个json为course数组的第一个值