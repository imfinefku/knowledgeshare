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
    var that = this;
    if (str==null || str==""){
      return ;
    }
    wx.request({
      url: app.globalData.apiUrl+"/open/getAllKnowledgeContent2",
      method:"GET",
      header:{
        "content-type":"application/x-www-form-urlencoded"
      },
      data: {
      },
      success: function(response){
        console.log(response.data.data);
        that.setData({
          showFlag:false,
          showHistoryFlag:false
        });
        var data=[];
          for(var i=0;i<response.data.data.length;i++){
            var knowledge=response.data.data[i];
            console.log(knowledge.title);
            if (knowledge.title.indexOf(str)>=0){
              data.push(knowledge);
            }
          }
        if (data.length>0){
          that.setData({
            noDataFlag:false
          });
        }else{
          that.setData({
            noDataFlag:true
          });
        }
        that.setData({
          searchData:data
        })
      }
    })
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
    if (data==null || data==""){
      return;
    }
    var historyData = wx.getStorageSync("history");
    if (historyData==null || historyData==""){
      historyData=new Array();
    }
    for (var i=0;i<historyData.length;i++){
      if (data==historyData[i]){
        return ;
      }
    }
    if (historyData.length>=5){
      historyData[0]=historyData[1];
      historyData[1]=historyData[2];
      historyData[2]=historyData[3];
      historyData[3]=historyData[4];
      historyData[4]=data;
    }else{
      historyData.push(data);
    }
    wx.setStorageSync("history", historyData);
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
    var historyData = wx.getStorageSync("history");
    if (historyData == null || historyData==""){
      historyData=new Array();
    }
    this.setData({
      historyData:historyData.reverse(),
      blueColor:app.globalData.blueColor
    })
    if (historyData.length>0){
      this.setData({
        showHistoryFlag:true,
        showFlag:true,
        noDataFlag:false,
        deleteHistoryFlag:false
      })
    }else{
      this.setData({
        showHistoryFlag:false,
        showFlag:true,
        noDataFlag:false,
        deleteHistoryFlag:false
      })
    }
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