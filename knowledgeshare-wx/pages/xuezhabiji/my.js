// pages/xuezhabiji/my.js
const app=getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    blueColor:app.globalData.blueColor,
    noLike:false,
    loadingFlag:false,
    buttonFlag:false,
    buttonContent:"去签到",
    signSuccess:false,
    signVideo:false,
    oneSignInScore:app.globalData.oneSignInScore,
    viewOver:false
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
    wx.getUserInfo({
      success(res) {
        that.setData({
          userInfo:res.userInfo
        })
      }
    })
  },

  toMyLike: function(){
    var like = wx.getStorageSync("like");
    if (like==null || like==""){
      like=new Array();
    }
    if (like.length==0){
      this.setData({
        noLike:true
      })
    }else{
      wx.navigateTo({
        url: '/pages/xuezhabiji/myLike',
      })
    }
  },

  setCurLevel: function(levels){
    var rankScore = wx.getStorageSync("rankScore");
    if (rankScore==null || rankScore==""){
      rankScore=0;
    }
    for (var i=0;i<levels.length;i++){
      if (rankScore>=levels[i].minScore &&
        rankScore<levels[i].maxScore){
          var nextLevelMessage="";
          if ((i+1)<levels.length){
            nextLevelMessage="距离下一段位【"+levels[i+1].title+"】,还需要"+(levels[i].maxScore-rankScore)+"积分。";
            nextLevelMessage+="可以点击签到按钮下方的看视频按钮获取积分。";
          }else{
            nextLevelMessage="恭喜您，已达到最高段位";
          }
          this.setData({
            rankScore:rankScore,
            curLevel:levels[i].title,
            curLevelIcon:levels[i].icon,
            nextLevel:nextLevelMessage
          })
      }
    }
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    this.setData({
      loadingFlag:true
    })
    this.setCurLevel(app.globalData.levels);
    this.setData({
      blueColor:app.globalData.blueColor
    })
    this.checkButtonFlag();
    this.setData({
      loadingFlag:false,
      duanwei:false
    })
  },

  setLikeNum: function(){
    var like = wx.getStorageSync("like");
    if (like==null || like==""){
      like=new Array();
    }
    this.setData({
      likeNum:like.length
    })
  },

  signIn: function(){
    this.setData({
      loadingFlag:true
    })
    var lastSignInDate = wx.getStorageSync("lastSignInDate");
    var date = new Date();
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var curDate = date.getDate();
    if (lastSignInDate!=null && lastSignInDate!=""){
      if (lastSignInDate==(year+month+curDate)){
        this.setData({
          loadingFlag:false
        })
        this.checkButtonFlag();
        return;
      }
    }
    this.setScore(app.globalData.oneSignInScore);
    wx.setStorageSync("lastSignInDate", year+month+curDate);
    this.setCurLevel(app.globalData.levels);
    this.checkButtonFlag();
    this.setData({
      loadingFlag:false
    })
    this.setData({
      signVideo:true
    })
  },

  setScore:function(score){
    var rankScore = wx.getStorageSync("rankScore");
    if (rankScore==null || rankScore==""){
      rankScore=0;
    }
    rankScore+=score;
    wx.setStorageSync("rankScore", rankScore);
  },

  noLookVideo:function(){
    this.setData({
      toastMessage:"签到成功，积分+"+app.globalData.oneSignInScore,
      signSuccess:true
    })
  },
  viedoMessage:function(message){
    this.setData({
      toastMessage:message,
      signSuccess:true
    })
  },

  checkButtonFlag: function(){
    var lastSignInDate = wx.getStorageSync("lastSignInDate");
    var date = new Date();
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var curDate = date.getDate();
    if (lastSignInDate!=null && lastSignInDate!=""){
      if (lastSignInDate==(year+month+curDate)){
        this.setData({
          buttonFlag:true,
          buttonContent:"已签到"
        })
        return ;
      }
    }
    this.setData({
      buttonFlag:false,
      buttonContent:"去签到"
    })
  },

  duanweimessage: function(){
    this.setData({
      duanwei:true
    })
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    this.setLikeNum();
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
    return app.globalData.shareData;
  }
})