const app=getApp();
Page({
  data: {
    loadingFlag:false,
    lastTitle:"",
    lastContent:"",
    blueColor:app.globalData.blueColor
  },
  titleInput:function(e)
  {
    this.setData({
      title: e.detail.value
    })
  },
  contentInput:function(e)
  {
    this.setData({
      content: e.detail.value
    })
  },

  submitProblem: function (e) {
    var that = this;
    if(this.data.title==null || this.data.title==""){
      wx.lin.showMessage({
        content:'标题不能为空',
        type:"error"
      })
    }else if(this.data.title.length>20){
      wx.lin.showMessage({
        content:'标题长度不能超过20字符',
        type:"error"
      })
    }else if(this.data.content==null || this.data.content==""){
      wx.lin.showMessage({
        content:'建议不能为空',
        type:"error"
      })
    }else if(this.data.content.length>2000){
      wx.lin.showMessage({
        content:'建议长度不能超过2000字符',
        type:"error"
      })
    }else if (that.data.lastTitle!="" && that.data.lastTitle==that.data.title && that.data.lastContent==that.data.content){
      wx.lin.showMessage({
        content:'请不要重复提交',
        type:"warning"
      })
    }
    else{
      wx.request({
        url: app.globalData.apiUrl+"/open/addProblem",
        method:"POST",
        header:{
          "content-type":"application/json"
        },
        data: {
          "title":that.data.title,
          "content":that.data.content
        },
        success: function(response){
          wx.lin.showMessage({
            content:'操作成功,感谢您的宝贵意见'
          })
          that.setData({
            lastTitle:that.data.title,
            lastContent:that.data.content
          })
        }
      })
    }
  },
  // 用户点击右上角分享
  onShareAppMessage: function () {
    return app.globalData.shareData;
  }
})