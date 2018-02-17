function imageUpload(file) {
    var formData = new FormData();
    formData.append("file", file);
    $.ajax({
        type: "POST",
        url: "/images/avatar",
        data: formData,
        contentType: false,
        processData: false,
        success: function (data) {
            $("#avatar").html("<img class=\"img-circle\" width='200' src='/files/" +
                data + "'/>");
        },
        error: function (data) {
            alert(data)
        }
    });

}