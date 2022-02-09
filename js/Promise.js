new Promise(function(resolve, reject){
    //立即执行
    console.log('new promise');
    setTimeout(()=>{ // 回调函数1
         console.log(11);
         resolve(12);  // 返回value给下一个then函数
    }, 2000);
}).then(function(value){  //回调函数2
        // 上一个promise resolve()后执行
        console.log(value); // 12
        return new Promise(function(resolve,reject){
            setTimeout(()=>{
                console.log(21); //21
                resolve(22);
            }, 2000);
        });
    }).then(function(value){ // 回调函数3
        // 上一个promise resolve()后执行
        console.log(value); //22
        setTimeout(()=>{
            console.log(31);
        }, 2000);
    });

    // 立即打印new promise, 1s 后打印11 12,2s后打印21 22 , 3s后打印 31
    // 通过new Promise(), 如果该promise 中含有异步调用 setTimeout,则会等到异步调用中执行resolve()时才会执行后面的then函数。
   // 如果then的回调函数中没有声明式的return new Promise(); 那么return会自动返回一个新的promise，所以也可以链式执行then函数。
   //  node Promise.js

