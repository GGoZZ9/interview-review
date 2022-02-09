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

        setTimeout(()=>{
            console.log(21); //21
        }, 2000);
        return 22;

    }).then(function(value){ // 回调函数3
        // 上一个promise resolve()后执行
        console.log(value); //22
        setTimeout(()=>{
            console.log(31);
        }, 2000);
    });

    // 1s后打印11 12 22 2s后打印 21 31