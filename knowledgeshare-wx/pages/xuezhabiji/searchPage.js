// pages/xuezhabiji/searchPage.js
const app=getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    searchData:[],
    searchWord:"",
    showFlag:true,
    showHistoryFlag:false,
    noDataFlag:false,
    deleteHistoryFlag:false
  },

  changeSearchWorld:function(e){
    this.searchWord=e.detail.value;
    if (this.searchWord == null || this.searchWord == ""){
      this.requireData();
      this.setData({
        searchData:[]
      })
    }
  },

  searchKnowledge: function(){
    var str=this.searchWord;
    this.searchKnowledge2(str);
    this.setHistory(str);
  },

  searchKnowledge2:function(str){
  },

  searchHistory:function(e){
    this.setData({
      searchWord:e.currentTarget.dataset.value
    })
    this.searchWord=e.currentTarget.dataset.value;
    this.searchKnowledge2(e.currentTarget.dataset.value);
    this.setHistory(e.currentTarget.dataset.value);
  },

  setHistory:function(data){
  },

  deleteHistory:function(){
    this.setData({
      deleteHistoryFlag:true
    })
  },

  deleteHistoryTrue:function(){
    wx.setStorageSync("history", []);
    this.requireData();
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.requireData();
  },

  requireData: function (){
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