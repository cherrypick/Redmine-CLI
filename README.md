Redmine CLI Tool 0.1
====================

> Redmine command line tool written in Java.

## Information

[Redmine](http://www.redmine.org/) is an open source project management tool developed by Jean-Philippe Lang since 2006. This tool provides access to your issues by an ease of use command line interface.

## Usage

Basic usage is `redmine -k <api-key> -u <url-to-redmine> OPTIONS` 

Whether `OPTIONS` can be one or many of:
```
   -p, --project <project>       Project to load issues from.
   -a, --assigned-to <assignee>  Assignee of issues to filter.
   -s, --status <status-id>      Status ID to filter issues.
   -t, --tracker <tracker-id>    Tracker ID to filter issues.
       --me                      Retrieves only self-assigned issues.
       --closed                  Only closed issues.
       --open                    Only open issues.
```

**Example:** Let's say your Redmine is located at *http://redmine.example.com*, and your API key is *abcdefghixyz1234567890*, then you could retrieve your open issues with:

```bash
redmine -u http://redmine.example.com -k abcdefghixyz1234567890 --me --open
```

## Getting Started

To get started, grab the [latest version here](https://github.com/CornyPhoenix/Redmine-CLI/releases/tag/v0.1).

Afterwards, I recommend you to set an alias for your own redmine in your `~/.bashrc`, like:

```bash
alias redmine="java -jar path/to/jar/redmine-cli.jar -k <api-key> -u <url>"
```

So that you can finally display your open tickets with

```bash
redmine --me --open
```
