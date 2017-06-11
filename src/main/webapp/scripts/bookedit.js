/**
 * Created by Administrator on 2016/12/8.
 */
/**
 * Created by Administrator on 2016/11/14.
 */
/**
 * Created by Administrator on 2016/11/8.
 */
$.validator.setDefaults( {

} );

$( document ).ready( function () {

    $( "#bookForm" ).validate( {
        rules: {
            bookname: {
                required: true
            }
        },
        messages: {
            username: {
                required: "Please enter a Book Name"
            }
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
