Confirm = {
  show: function (message, callback) {
    Swal.fire({
      title: '确认？',
      text: message,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: '确认!'
    }).then((result) => {
      //个人理解 当结果值 是真的情况  才去执行需要的函数
      if (result.value) {// 将变化的代码（组件无关的代码）作为回调函数传递进来
        if (callback) {
          callback()
        }
      }
    })



  }
}