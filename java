let time = function () {
  var date1 = new Date(document.getElementById("start_date"));
  var date2 = moment(date1);
  console.log(date2.format("DD-MM-YYYY"));
};
