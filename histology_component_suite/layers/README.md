This folder documents development and testing of the layers model

## Model objective
Segment small intestinal layers (villi vs crypts) in feline small intestinal biopsies

## Materials & methods
- **task type**: semantic segmentation (pixel classification)
- **Model architecture type & platform**: CNN, Aiforia create
- **Combination with other models in aiforia**: This model was chained with the 
models "compartments" and "lymphocytes" within Aiforia with layers as the 
parent model, "compartments" only run in recognized layers and "lymphocytes" 
only run in recognized compartments. This strategy can be cost efficient 
(although the cost is not completely explainable) 
SOP for combining models in aiforia:
https://docs.google.com/presentation/d/1TfTqYD7IXBNtEB0yTfHjLSWQN352mR_C/edit?usp=sharing&ouid=114290326180405247455&rtpof=true&sd=true
- **Tracking of version and combinations**: 
https://docs.google.com/spreadsheets/d/1Bg5ZT4h1TjjKgKP76iZ03OzNSspau0jlSxPWKsOVVXw/edit?usp=sharing
- **Active version**: fe_si_layers_pv6_mv11 in combinations fe_si_combos_pv2_mv2
- **Development**: This model was developed by KLJ in Aiforia and tested by JMW
- **Tuning** 
  - KLJ used a small set (n 21) for tuning. Most are from the labl_2020_tuning set but
some are from labl_2020_training. 
Documented here: https://drive.google.com/drive/folders/1EEyrtvhzGdj4grLw2vIOUCPeInp1xG9k?usp=sharing
  - JMW did new tuning annotations in qupath, used for initial eval and setting hyperparameters.
Presented here: https://drive.google.com/drive/u/1/folders/1T-lm4NHce23aOzehSpjrjDyMcNP6s_ut
- **Testing**: JMW annotated test set in qupath. Each negative class annotated separately (to
allow exploration of false positives). Used random rois 
(generated with fe_si_platforms/qupath/scripts/random_roi)

## Subfolders
- **scripts**
  - **import_rois.groovy**: imports random rois to qupath
  - **export_layer_annotations**: exports annotations from qupath
  - **validate_layers**: validates aiforia model against qupath annotations
  - **import_aiforia_annotations**: to view training annotations in qupath
  - **import ia_results_layers**:to view ai output in qupath
- **output**
  - **aiforia_annotations**
  contains KLJs annotations from aiforia (training and tuning) fetched with
  fe_si_platforms/aiforia/scripts/annotations
  - **export_layer_annotations**
  contains JMWs annotations in qupath (test set)
  - **qupath_random_roi**
  JMWs annotations in qupath used random rois 
  (generated with fe_si_platforms/qupath/scripts/random_roi)
  - **training_images_fe_si_layers_pv6**
  - **validate_layers**: output from "validate_layers" script

## Historic
Some previous versions of layers models are documented here:
https://drive.google.com/drive/folders/1bAlqsxGW6xRUn_r80pSiHJnZ8XRYBR1n?usp=sharing