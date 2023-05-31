// pages/xuezhabiji/knowledge.js
const app=getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    showMine:true
  },
  
  closeMine: function(){
    this.setData({
      showMine:false
    });
  },
  toSearch:function(e){
    wx.navigateTo({
      url: '/pages/xuezhabiji/searchPage',
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.showLoading({
      title: '数据加载中',
    })
    wx.request({
      url: app.globalData.apiUrl+"/open/getAllQuestionType",
      method:"GET",
      header:{
        "content-type":"application/x-www-form-urlencoded"
      },
      data: {
      },
      success: function(response){
        that.setData({
          dataList:response.data.data,
          blueColor:app.globalData.blueColor
        })
      }
    })
    wx.request({
      url: app.globalData.apiUrl+"/open/getAllKnowledge",
      method:"GET",
      header:{
        "content-type":"application/x-www-form-urlencoded"
      },
      data: {
      },
      success: function(response){
        that.setData({
          questionDataList:response.data.data,
          blueColor:app.globalData.blueColor
        })
        wx.hideLoading({
          success: (res) => {},
        })
      }
    })
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