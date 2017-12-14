/*
document.write("Hello World!");
confirm("入力を確定してもよろしいでしょうか？");


document.write(100);

var abc = 3+3;
document.write("<br>",abc);
document.write("<br>");
var a = 10;
document.write(a++);
document.write("<br>");
document.write(a);
document.write("<br>");
document.write(++a);
document.write("<br>");


var b = 7;
if(b > 10 && b < 20){
    document.write("A");
}else{
    alert("注意してください！");
}


var age = 40;
if(age < 20){
    document.write("未成年");
}else if(age >= 80){
    document.write("高齢者");
}else{
    document.write("成人");
}

document.write("<br>");

var kokugo = 80;
var suugaku = 65;
if(kokugo >= 70){
    if(suugaku >= 70){
        document.write("合格");
    }else{
        document.write("不合格");
    }
}

document.write("<br>");


var c = 5;
switch(c){
    case 0:
        document.write("aは0に等しい");
        break;
        
    case 1:
        document.write("aは1に等しい");
        break;
        
    default:
        document.write("aは0でも1でもない");
}


document.write("<br>");


for(var i = 1; i <= 10; i+=2){
    document.write(i);
}

document.write("<br>");


for(var s = 10; s>=3; s-=1){
    document.write(s);
}

document.write("<br>");


for(var p=1; p<=10; p++){
    if(p % 2 ==0){
        document.write(p+"<br>");
    }
}


//九九の表示
for(var k=1; k<=9; k++){
    for(var u=1; u<=9; u++){
        document.write(k*u+",");
    }
    document.write("→"+k+"の段<br>");
}



var d = 0;
while(d <= 10){
    document.write("★");
    d+=2;
      }

document.write("<br>");


//配列

//苗字の箱を作る
var myoji =["田中","高橋","斉藤"];
//苗字を表示→0田中、1高橋、2斉藤
document.write(myoji);
//箱０に入っている田中を削除→0なし、1高橋、2斉藤
delete myoji[0];
//鈴木を最後尾の箱4に追加→0なし、1高橋、2斉藤、3鈴木
myoji.push("鈴木");
//箱0の田中を加藤に変更→0加藤、1高橋、2斉藤、3鈴木
myoji[0]="加藤";
//伊藤を最前列の箱０に割り込ませる→0伊藤、1加藤、2高橋、3斉藤、4鈴木
myoji.unshift("伊藤");
//最前列の箱にいる伊藤を消す→0加藤、1高橋、2斉藤、3鈴木
myoji.shift();
//最後尾の箱にいる鈴木を消す→0加藤、1高橋、2斉藤
myoji.pop();
//段落をあける
document.write("<br>");
//配列苗字の箱0～箱2までにいる人を表示→0加藤、1高橋、2斉藤
document.write(myoji.slice(0,2));
//終了


document.write("<br>");


var myoji2 = {"A組":"田中","B組":"高橋","C組":"斉藤"};
document.write(myoji2["A組"]);


document.write("<br>");


function jikoshokai(shugo,myoji){
    return shugo + "の名前は" + myoji + "です。";
}

document.write(jikoshokai("私","山田"));
document.write("<br>");
document.write(jikoshokai("僕","鈴木"));
document.write("<br>");
document.write(jikoshokai("俺","佐藤"));
document.write("<br>");


*/


//演習問題★の出力

//問1
/*var a = 1;
while(a<=5){
    document.write("★");
    a++;
}

document.write("<br>");
document.write("<br>");
*/
for(var a=1; a<=5; a++){
    document.write("★");
}
document.write("<br>");
document.write("<br>");


//問2
/*for(var b=1; b<=2; b++){
    for(var c=1; c<=3; c++){
        document.write("★");
    }
    document.write("<br>")
}

document.write("<br>");
document.write("<br>");
*/
for(var a=1; a<=2; a++){
    for(var b=1; b<=3; b++){
        document.write("★");
    }
    document.write("<br>");
}
document.write("<br>");
document.write("<br>");


//問3
/*for(var b=1; b<=2; b++){
    for(var c=1; c<=5; c++){
        document.write("☆");
    }
    document.write("<br>");
}

document.write("<br>");
document.write("<br>");
*/
for(var a=1; a<=2; a++){
    for(var b=1; b<=5; b++){
        document.write("☆");
    }
    document.write("<br>");
}
document.write("<br>");
document.write("<br>");

//問4
for(var b=1; b<=4; b++){
    for(var c=1; c<=5; c++){
        document.write("★");
    }
    document.write("<br>");
}

document.write("<br>");
document.write("<br>");

//問5
for(var b=1; b<=4; b++){
    for(var c=1; c<=3; c++){
        document.write("★");
    }
    document.write("<br>");
}

document.write("<br>");
document.write("<br>");

//問6
/*for(var b=1; b<=3; b++){
    for(var c=1; c<=1; c++){
        document.write("★☆★");
    }
    document.write("<br>");
}

document.write("<br>");
document.write("<br>");
*/
for(var a=1; a<=4; a++){
    for(var b=1; b<=3; b++){
        if(b%2==0){
            document.write("☆");
        }else{
            document.write("★");
        }
    }
    document.write("<br>");
}
document.write("<br>");
document.write("<br>");

//問7
for(var b=1; b<=5; b++){
    for(var c=1; c<=1; c++){
        document.write("★☆★☆★");
    }
    document.write("<br>");
}

document.write("<br>");
document.write("<br>");

//問8
/*for(var b=1; b<=5; b++){
        switch(b){
            case 1:
                document.write("★");
                break;
            case 2:
                document.write("★★");
                break;
            case 3:
                document.write("★★★");
                break;
            case 4:
                document.write("★★★★");
                break;
            case 5:
                document.write("★★★★★");
                break;
    }
    document.write("<br>");
}
*/
for(var i=0; i<5; i++){
    for(var y=0; y<=i; y++){
        document.write("★");
    }
    document.write("<br>");
}
document.write("<br>");
document.write("<br>");


//上級演習

document.write("<br>");
document.write("<br>");

//問1
for(var b=1; b<=5; b++){
    for(var c=1; c<=5; c++){
        document.write("★");
    }
    document.write("<br>");
}

document.write("<br>");
document.write("<br>");

//問2
for(var b=1; b<=5; b++){
        switch(b){
            case 1:
                document.write("★☆★☆★");
                break;
            case 2:
                document.write("☆★☆★☆");
                break;
            case 3:
                document.write("★☆★☆★");
                break;
            case 4:
                document.write("☆★☆★☆");
                break;
            case 5:
                document.write("★☆★☆★");
                break;
    }
    document.write("<br>");
}

document.write("<br>");
document.write("<br>");

//問3
for(var b=1; b<=5; b++){
        switch(b){
            case 1:
                document.write("☆★★★★");
                break;
            case 2:
                document.write("★☆★★★");
                break;
            case 3:
                document.write("★★☆★★");
                break;
            case 4:
                document.write("★★★☆★");
                break;
            case 5:
                document.write("★★★★☆");
                break;
    }
    document.write("<br>");
}

document.write("<br>");
document.write("<br>");

//問4
for(var b=1; b<=5; b++){
        switch(b){
            case 1:
                document.write("★");
                break;
            case 2:
                document.write("★★");
                break;
            case 3:
                document.write("★★★");
                break;
            case 4:
                document.write("★★★★");
                break;
            case 5:
                document.write("★★★★★");
                break;
    }
    document.write("<br>");
}

document.write("<br>");
document.write("<br>");

//問5
/*for(var b=1; b<=5; b++){
        switch(b){
            case 1:
                document.write("☆");
                break;
            case 2:
                document.write("★☆");
                break;
            case 3:
                document.write("★★☆");
                break;
            case 4:
                document.write("★★★☆");
                break;
            case 5:
                document.write("★★★★☆");
                break;
    }
    document.write("<br>");
}
*/
for(i=0; i<=4; i++){
    for(j=0; j<=4; j++){
        if(j==i){
            document.write("☆");
            break;
        }else{
            document.write("★");
        }
    }
    document.write("<br>");
}

document.write("<br>");
document.write("<br>");



//関数
//問1
function theAreaOfACircle(hankei,ensyuritu=3.14){
    return(hankei * hankei * ensyuritu);
}
document.write(theAreaOfACircle(5));
document.write("<br>");
document.write(theAreaOfACircle(7));
document.write("<br>");
document.write(theAreaOfACircle(10));
document.write("<br>");


document.write("<br>");
document.write("<br>");


//問2
function totalPrice(numberOfAdult,numberOfChild,adultPrice=500,chikldPrice=200){
    return(numberOfAdult * adultPrice + numberOfChild * chikldPrice);
}
document.write(totalPrice(2,4));
document.write("<br>");
document.write(totalPrice(1,5));
document.write("<br>");
document.write(totalPrice(3,7));
document.write("<br>");


document.write("<br>");
document.write("<br>");