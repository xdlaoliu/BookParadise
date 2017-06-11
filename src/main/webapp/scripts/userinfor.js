/**
 * Created by Administrator on 2016/11/8.
 */
$.validator.setDefaults( {

} );


$( document ).ready( function () {

    $('.form_date').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });

    $("#dtp_input2").attr("value","");

    $( "#signupForm" ).validate( {
        rules: {
            username: {
                required: true,
                minlength: 2
            },
            //gender: {
            //    required: true
            //},
            //birthday: {
            //    required: true
            //},
            userpw:{
                required: true,
                minlength: 6
            },
            education: {
                required: true
            },
            agree: "required"
        },
        messages: {
            username: {
                required: "Please enter a username",
                minlength: "Your username must consist of at least 2 characters"
            },
            //gender: {
            //    required: "Please provide a gender"
            //},
            //birthday: {
            //    required: "Please provide a birthday"
            //},
            userpw:{
                required: "Please enter a password",
                minlength: "Your password must consist of at least 6 characters"
            },
            education: {
                required: "Please provide an education"
            },
            agree: "Please accept our policy"
        },
        errorElement: "em",
        errorPlacement: function ( error, element ) {
            // Add the `help-block` class to the error element
            error.addClass( "help-block" );

            if ( element.prop( "type" ) === "checkbox" ) {
                error.insertAfter( element.parent( "label" ) );
            } else {
                error.insertAfter( element );
            }
        },
        highlight: function ( element, errorClass, validClass ) {
            $( element ).parents( ".col-sm-5" ).addClass( "has-error" ).removeClass( "has-success" );
        },
        unhighlight: function (element, errorClass, validClass) {
            $( element ).parents( ".col-sm-5" ).addClass( "has-success" ).removeClass( "has-error" );
        }
    } );
} );
