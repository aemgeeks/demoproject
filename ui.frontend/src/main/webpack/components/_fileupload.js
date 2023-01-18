// Import FilePond
import * as FilePond from 'filepond';

// Import the plugin code
import FilePondPluginFileValidateSize from 'filepond-plugin-file-validate-size';
import FilePondPluginFileValidateType from 'filepond-plugin-file-validate-type';
import FilePondPluginFileEncode from 'filepond-plugin-file-encode';
import FilePondPluginImagePreview from 'filepond-plugin-image-preview';
import FilePondPluginImageExifOrientation from 'filepond-plugin-image-exif-orientation';


// Register the plugin
FilePond.registerPlugin(FilePondPluginFileValidateSize);
FilePond.registerPlugin(FilePondPluginFileValidateType);
FilePond.registerPlugin(FilePondPluginFileEncode);
FilePond.registerPlugin(FilePondPluginImagePreview);
FilePond.registerPlugin(FilePondPluginImageExifOrientation);

document.addEventListener('DOMContentLoaded', function(){

    const inputElement = document.querySelector('input[type="file"]');

    let errormsgcheck = document.querySelector(".uploadAttach")
    let errormsg;
    if(errormsgcheck){
        errormsg = errormsgcheck.dataset;
        
        // Create a FilePond instance

        if(errormsg){
            FilePond.create(inputElement, {
                acceptedFileTypes: ['image/*','application/pdf','application/msword','application/msword','application/vnd.openxmlformats-officedocument.wordprocessingml.document','application/vnd.ms-excel','application/vnd.openxmlformats-officedocument.spreadsheetml.sheet','video/mp4','text/plain'],
                labelMaxFileSizeExceeded: errormsg.filesize,
                fileValidateTypeLabelExpectedTypes: "",
                labelFileTypeNotAllowed: errormsg.filetype,
                credits: false,
                labelIdle: errormsg.uploadfile,
                labelFileLoading: errormsg.loadingfile,
                labelFileProcessing: errormsg.uploadingfile
            });
        }
    }
});