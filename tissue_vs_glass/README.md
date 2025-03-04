## Objective
This is a QuPath pixel classifier for classifying pixels as tissue vs glass.
The intended use is to 1) Use the model output as a base for identifying tissue fragments and 
2) Use as a parent model for the mucosal_layer_model (crypts_vs_villi)

SOP here: https://docs.google.com/presentation/d/1g9QMLUlkV8ITmbK1x9Ol7yW0G8M7sXVrNF_m_vysnBk/edit?usp=drive_link

## Model type
A multi-layer perceptron (MLP) (a shallow artificial neural network ANN) - this
type of network uses hand-crafted features (for this one RGB pixel values and gaussian filters) 

## Case material
Training: labl_2020_training (added by batch until satisfactory performance in tuning set - only batch 1 and 2)
Tuning: labl_2020_tuning
Test: labl_2020_test

## Training annotations
see SOP

## Hyperparameters
Model type and hyperparameters were set based on assessments in the training set
(procedure in SOP) and documented here: 
https://docs.google.com/spreadsheets/d/14arTrgun_KB4gPumhx4ZE5X8JcgudXyupEgvB8jFlgA/edit?usp=sharing

## Tuning assessment
Output visually assessed in whole slide images, and documented here:
https://docs.google.com/spreadsheets/d/1uXLYJ0KbuQHwRvG_OOtYaGBr4jlTv9TtmFlvYeLK7-4/edit?usp=sharing 
and in SOP

## Testing
This can be tested using the test annotations for the mucosal layer model, but merging
annotations for villi, crypts, muscularis_mucosa, submucosa, muscularis_propria, 
gastric mucosa, rafts and blood as tissue and pen, print and empty as glass.