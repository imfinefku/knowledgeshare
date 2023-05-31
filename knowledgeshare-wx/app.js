App({
  globalData: {
    blueColor:"#3d82f5",
    apiUrl:"http://127.0.0.1:10000",
    imageUrl:"http://127.0.0.1:10000" + "/showImage/",
    shareData:{
      title: '年薪30万的秘密就在这里',
      path: '/pages/xuezhabiji/knowledge',
      imageUrl: '/images/share.png'
    },
    levels:[
      {"title":"倔强青铜","minScore":"0","maxScore":"10","icon":"../../images/1.png"},
      {"title":"不屈白银","minScore":"10","maxScore":"50","icon":"../../images/2.png"},
      {"title":"荣耀黄金","minScore":"50","maxScore":"100","icon":"../../images/3.png"},
      {"title":"华贵铂金","minScore":"100","maxScore":"250","icon":"../../images/4.png"},
      {"title":"璀璨钻石","minScore":"250","maxScore":"500","icon":"../../images/5.png"},
      {"title":"超凡大师","minScore":"500","maxScore":"1000","icon":"../../images/6.png"},
      {"title":"最强王者","minScore":"1000","maxScore":"10000000000","icon":"../../images/7.png"}
    ],
    oneSignInScore:15
  }
})