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
    this.setData({
      loadingFlag:true
    })
    var like = wx.getStorageSync("like");
    if (like==null || like==""){
      like=new Array();
    }
    for (var i=0;i<like.length;i++){
      if (like[i]==curId){
        like.splice(i, 1); 
      }
    }
    wx.setStorageSync("like", like);
    this.searchLike();
    this.setData({
      loadingFlag:false
    })
  },

  searchLike: function(){
    this.setData({
      loadingFlag:true
    })
    var like = wx.getStorageSync("like");
    if (like==null || like==""){
      like=new Array();
    }
    for (var i=0;i<like.length;i++){
      if (like[i]==curId){
        this.setData({
          iflike:"取消收藏",
          likeMethod:"removeLike",
          loadingFlag:false
        })
        return ;
      }
    }
    this.setData({
      iflike:"收藏",
      likeMethod:"addLike",
      loadingFlag:false
    })
  },

  getData:function (id){
    var that = this;
    wx.request({
      url: app.globalData.apiUrl+"/open/getAllKnowledgeContent",
      method:"GET",
      header:{
        "content-type":"application/x-www-form-urlencoded"
      },
      data: {
      },
      success: function(response){
        var knowledgeContent = response.data.data;
        curId = id;
        that.searchLike();
        wx.showLoading({
          title: '数据加载中',
        })
        that.setData({
          title:knowledgeContent[id].title,
          content:knowledgeContent[id].content,
          blueColor:app.globalData.blueColor
        })
        var like = wx.getStorageSync("like");
        if (like==null || like==""){
          like=new Array();
        }
        for (var cur=0;cur<like.length;cur++){
          if (id==like[cur]){
            if ((cur-1)<0){
              lastid=null;
            }else{
              lastid=like[cur-1];
            }
            if ((cur+1)>(like.length-1)){
              nextid=null;
            }else{
              nextid=like[cur+1];
            }
          }
        }
        if (lastid==null){
          that.setData({
            lastshow:"none"
          })
        }else{
          that.setData({
            lastshow:""
          })
        }
        if (nextid==null){
          that.setData({
            nextshow:"none"
          })
        }else{
          that.setData({
            nextshow:""
          })
        }
        wx.hideLoading({
          success: (res) => {},
        })
      }
    })

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