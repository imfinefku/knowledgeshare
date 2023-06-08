// pages/xuezhabiji/knowledge_type_knowledge.js
const app=getApp();
var lastid;
var nextid;
var curId;
Page({

  /**
   * 页面的初始数据
   */
  data: {
    dataId:"",
    loadingFlag:false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getData(options.id);
  },

  addLike: function(){
    this.setData({
      loadingFlag:true
    })
    var like = wx.getStorageSync("like");
    if (like==null || like==""){
      like=new Array();
    }
    like.push(curId);
    wx.setStorageSync("like", like);
    this.searchLike();
    this.setData({
      loadingFlag:false
    })
  },
  
  removeLike: function(){
  },

  searchLike: function(){
  },

  getData:function (id){
  },
  toLast:function (event) {
    var that=this; 
    that.getData(lastid);
  },
  toNext:function (event) {
    var that=this; 
    that.getData(nextid);
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

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